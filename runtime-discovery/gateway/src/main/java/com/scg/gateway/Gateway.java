package com.scg.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class Gateway {

	public static void main(String[] args) {
		SpringApplication.run(Gateway.class, args);
	}

//	@RestController
//	public class restController {
//		@GetMapping("/connect")
//		public boolean connect() throws IOException {
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//			LocalDateTime now = LocalDateTime.now();
//			System.out.println(dtf.format(now) + " Connection tested");
//			return true;
//		}
//	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder, TokenRelayGatewayFilterFactory tokenRelay) {
		return builder.routes().route("servlet-app",
				r -> r.path("/profile", "/").filters(f -> f.filter(tokenRelay.apply())).uri("http://localhost:8000"))
				.build();
	}
}
