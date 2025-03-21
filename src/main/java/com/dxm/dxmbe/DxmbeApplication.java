package com.dxm.dxmbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.dxm.dxmbe.model"})
@EnableJpaRepositories("com.dxm.dxmbe.repository")
@PropertySource("classpath:application.properties")
public class DxmbeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DxmbeApplication.class, args);
	}

}
