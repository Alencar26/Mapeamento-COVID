package com.covid.mapcovid.Controller;

import java.text.NumberFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.covid.mapcovid.Model.Entities.Country;
import com.covid.mapcovid.Model.Entities.CountryOperation;
import com.covid.mapcovid.Model.Enums.Countries;

@Controller
public class WebController {
	
	@GetMapping({"/"})
    public String index(Model model)  {
    	
    	Country countrySelect = CountryOperation.GetCountry("Brazil");
    	
   	 	model.addAttribute("nomePais", "Brasil");	
        model.addAttribute("totalCasos", NumberFormat.getIntegerInstance().format(countrySelect.getCases()));
        model.addAttribute("totalAtivos", NumberFormat.getIntegerInstance().format(countrySelect.getActive()));
        model.addAttribute("totalObitos", NumberFormat.getIntegerInstance().format(countrySelect.getDeaths()));
        model.addAttribute("totalRecuperados", NumberFormat.getIntegerInstance().format(countrySelect.getRecovered()));
        model.addAttribute("bandeira", countrySelect.getCountryInfo().getFlag());
        model.addAttribute("populacao",  NumberFormat.getIntegerInstance().format(countrySelect.getPopulation()));
        return "index";
    }
	
}
