package com.cqut.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SurveyFilter
 */
@WebFilter("/quesManage.jsp")
public class SurveyFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SurveyFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 登陆请求、初始请求直接放行
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		if (uri.endsWith("/AdminLogin") || uri.endsWith("/adminLogin.jsp")) {
			// 放行
			chain.doFilter(request, response);
			return;
		}

		HttpSession httpSession = req.getSession();
		if (httpSession.getAttribute("userName") == null) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect("adminLogin.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
