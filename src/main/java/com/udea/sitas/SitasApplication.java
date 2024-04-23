package com.udea.sitas;

import com.udea.sitas.dao.config.SitasDaoConfig;
import com.udea.sitas.persistence.config.SitasPersistenceConfig;
import com.udea.sitas.service.config.SitasServiceConfig;
import com.udea.sitas.web.config.SitasWebConfig;
import com.udea.sitas.web.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        SwaggerConfig.class,
        SitasDaoConfig.class,
        SitasPersistenceConfig.class,
        SitasServiceConfig.class,
        SitasWebConfig.class
})
public class SitasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SitasApplication.class, args);
    }
}
