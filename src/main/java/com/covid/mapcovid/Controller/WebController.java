package com.covid.mapcovid.Controller;

import java.text.NumberFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.covid.mapcovid.Model.Entities.Continent;
import com.covid.mapcovid.Model.Entities.ContinentOperation;
import com.covid.mapcovid.Model.Entities.Country;
import com.covid.mapcovid.Model.Entities.CountryOperation;
import com.covid.mapcovid.Model.Enums.Countries;

@Controller
public class WebController {
	
	@GetMapping({"/"})
    public String index(Model model)  {
    	
		
		
		Continent continentSelect = ContinentOperation.GetContinent("South%20America");
    	
		System.out.println(continentSelect);
		
   	 	model.addAttribute("nomePais", "America do Sul");	
        model.addAttribute("totalCasos", NumberFormat.getIntegerInstance().format(continentSelect.getCases()));
        model.addAttribute("totalAtivos", NumberFormat.getIntegerInstance().format(continentSelect.getActive()));
        model.addAttribute("totalObitos", NumberFormat.getIntegerInstance().format(continentSelect.getDeaths()));
        model.addAttribute("totalRecuperados", NumberFormat.getIntegerInstance().format(continentSelect.getRecovered()));
        model.addAttribute("populacao",  NumberFormat.getIntegerInstance().format(continentSelect.getPopulation()));
        return "index";
       
    }
	
}
