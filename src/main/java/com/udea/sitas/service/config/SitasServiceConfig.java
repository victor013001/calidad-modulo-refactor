package com.udea.sitas.service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.udea.sitas.service.component"})
public class SitasServiceConfig {
}
