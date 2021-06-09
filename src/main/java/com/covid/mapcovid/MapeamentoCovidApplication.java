package com.covid.mapcovid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.covid.mapcovid.Controller.CountriesController;
import com.covid.mapcovid.useCase.CovidDataUseCase;

@SpringBootApplication
public class MapeamentoCovidApplication {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MapeamentoCovidApplication.class);
    }
    
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MapeamentoCovidApplication.class, args);
		
	}

}
