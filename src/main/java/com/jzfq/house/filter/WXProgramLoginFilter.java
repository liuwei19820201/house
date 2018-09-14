package com.jzfq.house.filter;

import com.jzfq.house.redis.RedisService;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.util.JsonMapper;
import com.jzfq.house.util.JwtHelper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title: WXProgramLoginFilter
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 16:05
 */
@Slf4j
@Order(1)
@WebFilter(filterName = "wxProgramLoginFilter", urlPatterns = {"/amp/*", "/dsmp/*", "/mp/*", "/pc/*"},
        initParams = @WebInitParam(name = "paramName", value = "paramValue"))
public class WXProgramLoginFilter implements Filter {

    @Value("${wx.login.jwt.sec}")
    private String WX_LOGIN_JWT_SEC;

    @Value("${wx.login.jwt.tokenName}")
    private String WX_LOGIN_JWT_TOKEN_NAME;

    @Value("${wx.login.useFilter}")
    private boolean WX_LOGIN_USE_FILTER;

    @Autowired
    private RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, accessToken");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String method = request.getMethod();
        if (!"OPTIONS".equals(method)) {
            //登录过滤器，使用
            if (WX_LOGIN_USE_FILTER) {
                boolean isLogin = false;
                String token = request.getHeader(WX_LOGIN_JWT_TOKEN_NAME);
                if (StringUtils.isNotBlank(token)) {
                    Claims claims = JwtHelper.parseJWT(token, WX_LOGIN_JWT_SEC);
                    // 没有过期
                    if (claims != null) {
                        //USER_CODE@PHONE
                        String tokenStr = (String) claims.get("username");
                        log.info("WX PROGRAM LOGIN TOKEN STR:{}", tokenStr);
                        String[] str = tokenStr.split("@");
                        log.info("WX PROGRAM LOGIN TOKEN STR LENGTH:{}", str.length);
                        if (str.length == 2 && StringUtils.isNotBlank(str[0])) {
                            if (redisService.getForString(str[0]) != null) {
                                isLogin = true;
                            }
                        }
                    }
                }
                if (isLogin) {
                    //已登录
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    TouchResponseModel responseModel = new TouchResponseModel();
                    responseModel.setErrorCode("401");
                    responseModel.setMsg("登录失败");
                    responseModel.setData(null);
                    responseModel.setResult("0");
                    response.getWriter().write(JsonMapper.nonDefaultMapper().toJson(responseModel));
                }
            } else {
                //登录过滤器，不使用
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {
    }
}
