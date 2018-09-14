package com.jzfq.house.filter;

import com.jzfq.house.mybatis.domain.LoginDTO;
import com.jzfq.house.service.LoginManage;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.LoginInfo;
import com.jzfq.house.util.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-08-24T01:49:38.472Z")

public class LoginFilter extends BaseModel implements Filter {

	@Autowired
	LoginManage loginManage;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setContentType("text/plain;charset=UTF-8");
		String method = req.getMethod();
		if(!"OPTIONS".equals(method)){
			String ticket = req.getHeader("ticket");
			if(StringUtils.isBlank(ticket)){
				loginFail(res);
			}else{
				LoginInfo loginInfo = loginManage.getLoginInfo(ticket, null);
				if(loginInfo != null){
					chain.doFilter(request, response);
				}else{
					loginFail(res);
				}
			}
		}
	}

	private void loginFail(HttpServletResponse res) throws IOException {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setCode("401");
		loginDTO.setMessage("未登录");
		String json = new JsonMapper().toJson(loginDTO);
		res.getWriter().write(json);
	}


	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}