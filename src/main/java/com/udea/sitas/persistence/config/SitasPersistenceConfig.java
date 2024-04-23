package com.udea.sitas.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EntityScan(basePackages = {"com.udea.sitas.persistence.component"})
@Import(ModelMapperConfig.class)
public class SitasPersistenceConfig {
}
