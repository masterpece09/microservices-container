package com.in28min.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		Function<PredicateSpec, Buildable<Route>> routeFuntion = p -> p.path("/get")
				                                                       .uri("http://httpbin.org:80");
		
		Function<PredicateSpec, Buildable<Route>> routeFuntionCurrency = p -> p.path("/currency-exchange/**")
                                                                               .uri("lb://currency-exchange"
                                                                               		+ "");
		Function<PredicateSpec, Buildable<Route>> routeFuntionCurrencyFeign = p -> p.path("/currency-conversion-feign/**")
				                                                                    .uri("lb://currency-conversion"
						+ "");
		
		Function<PredicateSpec, Buildable<Route>> routeFuntionCurrencyConversion = p -> p.path("/currency-conversion/**")
				.uri("lb://currency-conversion"
						+ "");
		
		return builder.routes()
				.route(routeFuntion)
				.route(routeFuntionCurrency )
				.route(routeFuntionCurrencyFeign )
				.route(routeFuntionCurrencyConversion )
				.build();
	}

}
