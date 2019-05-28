package br.com.zenganet.segurancaoauth2jwt.token;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefleshTokenCookiePreProcessorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		if ( req.getRequestURI().contains("/oauth/token")
				&& "refresh_token".equals(req.getParameter("grant_type")) 
				&& req.getCookies() != null) {

			for (Cookie cookie : req.getCookies()) {
				if (cookie.getName().equals("refleshToken")) {
					String refleshToken = cookie.getValue();
					req = new MyServletRequestWrapper(req, refleshToken);
				}
			}
		}
		
		chain.doFilter(req, response);
	}

	static class MyServletRequestWrapper extends HttpServletRequestWrapper {

		private String refleshToken;

		public MyServletRequestWrapper(HttpServletRequest request, String refleshToken) {
			super(request);
			this.refleshToken = refleshToken;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
			map.put("refresh_token", new String[] { refleshToken });
			map.setLocked(true);
			return map;
		}
	}
	
}
