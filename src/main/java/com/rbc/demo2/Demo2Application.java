package com.rbc.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class Demo2Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Demo2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
		LOGGER.info("Welcome to Demo App!");
	}

	@Bean
	public Docket itemApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rbc.demo2")).build();
	}

	// @Bean
	// public CacheManager cacheManager() {
	// 	CaffeineCacheManager cacheManager = new CaffeineCacheManager("customer");
	// 	cacheManager.setCaffeine(caffeineCacheBuilder());
	// 	return cacheManager;
	// }

	// Caffeine<Object, Object> caffeineCacheBuilder() {
	// 	return Caffeine.newBuilder().initialCapacity(100).maximumSize(500).expireAfterAccess(10, TimeUnit.SECONDS)
	// 			.weakKeys().recordStats();
	// }

}
