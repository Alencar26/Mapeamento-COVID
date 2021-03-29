package com.covid.mapcovid.Controller;

import com.covid.mapcovid.Model.Entities.Country;
import com.covid.mapcovid.Model.Entities.CountryInfo;
import com.covid.mapcovid.Model.Entities.CountryOperation;
import com.covid.mapcovid.Model.Entities.Request;
import com.covid.mapcovid.Model.Enums.Countries;
import com.covid.mapcovid.Model.Services.JsonCountry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.NumberFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {

	@RequestMapping(value = "/country", method = RequestMethod.POST)
    public String countryChange(@RequestParam(defaultValue = "Brazil") String country, Model model) {
    	
    	 Country countrySelect = CountryOperation.GetCountry(country);

    	 System.out.println(countrySelect.getCountryInfo());
    	
    	 model.addAttribute("nomePais", country);
    	 model.addAttribute("totalCasos", NumberFormat.getIntegerInstance().format(countrySelect.getCases()));
         model.addAttribute("totalAtivos", NumberFormat.getIntegerInstance().format(countrySelect.getActive()));
         model.addAttribute("totalObitos", NumberFormat.getIntegerInstance().format(countrySelect.getDeaths()));
         model.addAttribute("totalRecuperados", NumberFormat.getIntegerInstance().format(countrySelect.getRecovered()));
         model.addAttribute("bandeira", countrySelect.getCountryInfo().getFlag());
         model.addAttribute("populacao",  NumberFormat.getIntegerInstance().format(countrySelect.getPopulation()));

        return "index";
    }
	

	@RequestMapping(value = "/countryJSON", method = RequestMethod.POST)
    public Country countryChangeJSON(@RequestBody Request request) {
    	
		System.out.println(request.getName());
						
   	 	Country countrySelect = CountryOperation.GetCountry(request.getName());

		 return countrySelect;
	}

}
