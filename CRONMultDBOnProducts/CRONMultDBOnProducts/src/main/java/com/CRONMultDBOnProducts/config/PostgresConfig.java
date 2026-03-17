package com.CRONMultDBOnProducts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.CRONMultDBOnProducts.repository.postgresql"
)
public class PostgresConfig {
}