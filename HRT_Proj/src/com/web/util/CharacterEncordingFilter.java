package com.web.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncordingFilter implements Filter{
	private String encording;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encording);
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encording = config.getInitParameter("encording");
		System.out.println("encording :" + encording);
	}
}
