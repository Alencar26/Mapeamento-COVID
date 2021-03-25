package com.covid.mapcovid.Controller;

import com.covid.mapcovid.Model.Entities.Country;
import com.covid.mapcovid.Model.Entities.CountryOperation;
import com.covid.mapcovid.Model.Enums.Countries;

import java.text.NumberFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CountriesController {

	@GetMapping({"/"})
    public String index(Model model)  {
    	
    	Country countrySelect = CountryOperation.GetCountry(Countries.valueOf("Brazil"));
    	
   	 	model.addAttribute("nomePais", "Brasil");	
        model.addAttribute("totalCasos", NumberFormat.getIntegerInstance().format(countrySelect.getCases()));
        model.addAttribute("totalAtivos", NumberFormat.getIntegerInstance().format(countrySelect.getActive()));
        model.addAttribute("totalObitos", NumberFormat.getIntegerInstance().format(countrySelect.getDeaths()));
        model.addAttribute("totalRecuperados", NumberFormat.getIntegerInstance().format(countrySelect.getRecovered()));
        return "index";
    }
	
	@RequestMapping(value = "/country", method = RequestMethod.POST)
    public String countryChange(@RequestParam(defaultValue = "Brazil") Countries country, Model model) {
    	
    	Country countrySelect = CountryOperation.GetCountry(country);
    	
    	 model.addAttribute("nomePais", country.getCountries());
    	 model.addAttribute("totalCasos", NumberFormat.getIntegerInstance().format(countrySelect.getCases()));
         model.addAttribute("totalAtivos", NumberFormat.getIntegerInstance().format(countrySelect.getActive()));
         model.addAttribute("totalObitos", NumberFormat.getIntegerInstance().format(countrySelect.getDeaths()));
         model.addAttribute("totalRecuperados", NumberFormat.getIntegerInstance().format(countrySelect.getRecovered()));
        return "index";
    }

}
