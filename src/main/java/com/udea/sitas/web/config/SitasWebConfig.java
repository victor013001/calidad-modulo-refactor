package com.udea.sitas.web.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.udea.sitas.web.controller"})
public class SitasWebConfig {
}
