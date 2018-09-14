package com.jzfq.house;

import com.jzfq.house.filter.LoginFilter;
import com.jzfq.house.swagger.api.sys.ApiOriginFilter;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;

@Slf4j
@RestController
@SpringBootApplication
@MapperScan("com.jzfq.house.mybatis.mapper")
@EnableJpaRepositories(basePackages = "com.jzfq.house")
public class JzfqHouseApplication {

	/**
	 * 配置过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(apiOriginFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("apiOriginFilter");
		return registration;
	}

	/**
	 * 配置过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean loginFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(loginFilter());
		registration.addUrlPatterns("/api/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("loginFilter");
		registration.setOrder(Integer.MAX_VALUE);
		return registration;
	}

	/**
	 * 创建一个bean
	 * @return
	 */
	@Bean(name = "apiOriginFilter")
	public Filter apiOriginFilter() {
		return new ApiOriginFilter();
	}
	/**
	 * 创建一个bean
	 * @return
	 */
	@Bean(name = "loginFilter")
	public Filter loginFilter() {
		return new LoginFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(JzfqHouseApplication.class, args);
		log.info("==================juzi START SUCCESS========================");
	}
}
