package com.bin.mybatis.plus.filter;

import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author shaobin.qin
 */
@WebFilter(filterName="loggingProcessFilter", urlPatterns={"/*"})
public class LoggingProcessFilter extends OncePerRequestFilter {

	private static final String SESSION_ID = "sessionId";

	private static RandomStringGenerator builder = new RandomStringGenerator.Builder().withinRange('0', '9').build();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String sessionId = builder.generate(6) + Thread.currentThread().getId();

		//扩展日志追踪号
		MDC.put(SESSION_ID, sessionId);
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.clear();
		}

	}

}
