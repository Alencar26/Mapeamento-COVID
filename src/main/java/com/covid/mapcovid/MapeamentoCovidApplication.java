package com.covid.mapcovid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MapeamentoCovidApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MapeamentoCovidApplication.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(MapeamentoCovidApplication.class, args);
	}

}
