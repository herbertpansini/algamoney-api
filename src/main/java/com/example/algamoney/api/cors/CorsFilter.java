package com.example.algamoney.api.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	private String originPermitida = "http://localhost:8000"; // TODO: Configurar para diferentes ambientes
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		resp.setHeader("Access-Control-Allow-Origin", originPermitida);
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		
		if ("OPTIONS".equals(req.getMethod()) && originPermitida.equals(req.getHeader("Origin"))) {
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			resp.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			resp.setHeader("Access-Control-Max-Age", "3600");
			
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(request, response);
		}
	}
}