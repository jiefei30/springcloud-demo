package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DELL
 * @date 2020/3/16 11:04
 */
@Configuration
public class GateWayConfig {
        @Bean
        public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

            RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
            routes.route("path_route"
                    , r->r.path("/guonei").uri("http://news.baidu.com/guonei"))
                    .build();
            return routes.build();
        }
}
