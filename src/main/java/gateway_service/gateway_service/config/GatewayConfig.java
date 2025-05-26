package gateway_service.gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator (RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p -> p.path("/api/driver/**")
                        .uri("lb://driver-service"))
                .route(p -> p.path("/api/traveler/**")
                        .uri("lb://traveler-service"))
                .route(p -> p.path("/api/train/**")
                        .uri("lb://train-service"))


                .build();
    }
}
