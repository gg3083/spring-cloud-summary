package com.gg.backend.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author gimi
 */
@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger2Config {

    @Value("${security.oauth2.client.access-token-uri}")
    private String AUTH_SERVER;
    @Value("${security.oauth2.client.client-id}")
    private String clientId;
    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;
    private static final Predicate<String> SWAGGER_PATHS = regex("^(?!.*error$).*");
    public static final String securitySchemaOAuth2 = "oauth2schema";

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("v2") .apiInfo(apiInfo())
                .select().paths(postPaths())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .paths(springBootActuatorJmxPaths())
                .build()
                //oauth2 认证类
                .securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private Predicate<String> postPaths() {
        return regex("/.*");
    }

    private Predicate<String> springBootActuatorJmxPaths() {
        return regex("^/(?!env|restart|pause|resume|refresh).*$");
    }



    /**
     * 这个方法主要是写一些文档的描述
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "接口文档",
                "这是描述!",
                "版本1.0",
                "",
                new Contact("Gimi", "http://thinkpad-pc:9001/actuator", ""),
                "2.0", "", Collections.emptyList());
    }


    /**
     * 这里使用 ResourceOwnerPasswordCredentialsGrant 也就是password授权方式
     * @return
     */
    private OAuth securitySchema() {
        //这里设置 client 的 scope
        final AuthorizationScope authorizationScope = new AuthorizationScope("all", "允许测试阶段访问的所有接口");
        final GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER);
        return new OAuth(securitySchemaOAuth2, Arrays.asList(authorizationScope), Arrays.asList(grantType));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(this.defaultAuth())
                .forPaths(SWAGGER_PATHS)
                .build();
    }

    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(clientId, clientSecret, "", "", "", ApiKeyVehicle.HEADER, "", " ");
    }

    private List<SecurityReference> defaultAuth() {
        final AuthorizationScope authorizationScope =
                new AuthorizationScope("openid", "允许测试阶段访问的所有接口");
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
                new SecurityReference(securitySchemaOAuth2, authorizationScopes));
    }



}
