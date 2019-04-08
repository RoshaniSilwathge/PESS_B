package lk.ac.cmb.ucsc.pess.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String AUTH_HEADER_NAME = "Authorization";
	private static final String AUTH_KEY_TYPE = "header";
	private static final String API_PATH = "/api/**";
	private static final String BASE_PACKAGE = "lk.ac.cmb.ucsc.pess";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.ant(API_PATH)).build().securitySchemes(Arrays.asList(apiKey()));
	}

	private ApiKey apiKey() {
		return new ApiKey(AUTH_HEADER_NAME, AUTH_HEADER_NAME, AUTH_KEY_TYPE);
	}

}
