package com.udea.sitas.dao.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.udea.sitas.dao.entity"})
@EnableJpaRepositories(basePackages = {"com.udea.sitas.dao.repository"})
public class SitasDaoConfig {
}
