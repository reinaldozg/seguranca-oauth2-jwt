package br.com.zenganet.segurancaoauth2jwt.swagger;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static String AUTH_SERVER = "localhost:8080/seguro-oauth2-jwt";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(apis())
				.paths(PathSelectors.any()).build()
				.securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContext()))
				.apiInfo(apiInfo());
	}

	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder()
				.clientId("angular")
				.clientSecret("@ngul@r0")
				.scopeSeparator(" ")
				.useBasicAuthenticationWithAccessCodeGrant(true)
				.build();
	}


	private SecurityScheme securityScheme() {
		GrantType grantType = new AuthorizationCodeGrantBuilder()
				.tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/oauth/token", "access_token"))
				.tokenRequestEndpoint(new TokenRequestEndpoint(AUTH_SERVER + "/oauth/token","angular", "$2a$10$453i7Ka25I1MLjzsVn41auy6gYceTb.GclTq0oh0L1tb7TLUDyPoW"))
				.build();

		SecurityScheme oauth = new OAuthBuilder().name("SegurancaOauth2Jwt").grantTypes(Arrays.asList(grantType))
				.scopes(Arrays.asList(scopes())).build();
		return oauth;
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes())))
				.forPaths(PathSelectors.regex("/foos.*")).build();
	}

	private AuthorizationScope[] scopes() {
		AuthorizationScope[] scopes = {
				new AuthorizationScope("read", "operações de leitura"),
				new AuthorizationScope("write", "operações de escrita") };
		return scopes;
	}
	
	private Predicate<RequestHandler> apis() {
		return RequestHandlerSelectors.basePackage("br.com.zenganet.segurancaoauth2jwt");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder().title("Spring Security Oauth2 + Jwt")
				.description("Este projeto tem como objetivo implementar a segurança Oauth2 com Spring Security e Jwt")
				.version("1.0.0").contact(new Contact("Reinaldo dos Santos", "reinaldo.developer@outlook.com",
						"reinaldo.santos@live.com"))
				.build();

		return apiInfo;
	}

}
