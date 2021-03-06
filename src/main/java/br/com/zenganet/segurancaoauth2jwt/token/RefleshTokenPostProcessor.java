package br.com.zenganet.segurancaoauth2jwt.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RefleshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return returnType.getMethod().getName().equals("postAccessToken");
	}

	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {

		HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();
		HttpServletResponse resp = ((ServletServerHttpResponse) response).getServletResponse();

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;

		String refleshToken = body.getRefreshToken().getValue();
		adicionarRefleshTokenNoCookie(refleshToken, req, resp);
		removerRefleshTokenDoBody(token);

		return body;
	}

	private void removerRefleshTokenDoBody(DefaultOAuth2AccessToken token) {
		token.setRefreshToken(null);
	}

	private void adicionarRefleshTokenNoCookie(String refleshToken, HttpServletRequest req, HttpServletResponse resp) {
		Cookie refleshTokenCookie = new Cookie("refleshToken", refleshToken);
		refleshTokenCookie.setHttpOnly(true);
		refleshTokenCookie.setSecure(false); // Mudar para true em produção
		refleshTokenCookie.setPath(req.getContextPath() + "/oauth/token");
		refleshTokenCookie.setMaxAge(2592000);
		resp.addCookie(refleshTokenCookie);
	}

}
