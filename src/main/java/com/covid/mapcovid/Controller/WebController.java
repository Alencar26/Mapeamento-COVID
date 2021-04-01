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
		
   	 	model.addAttribute("nomePais", "América do Sul");	
        model.addAttribute("totalCasos", NumberFormat.getIntegerInstance().format(countrySelect.getCases()));
        model.addAttribute("totalAtivos", NumberFormat.getIntegerInstance().format(countrySelect.getActive()));
        model.addAttribute("totalObitos", NumberFormat.getIntegerInstance().format(countrySelect.getDeaths()));
        model.addAttribute("totalRecuperados", NumberFormat.getIntegerInstance().format(countrySelect.getRecovered()));
        model.addAttribute("totalTestes", NumberFormat.getIntegerInstance().format(countrySelect.getTests()));
        model.addAttribute("totalCriticos", NumberFormat.getIntegerInstance().format(countrySelect.getCritical()));
        model.addAttribute("populacao",  NumberFormat.getIntegerInstance().format(countrySelect.getPopulation()));
        model.addAttribute("hojeCasos", NumberFormat.getIntegerInstance().format(countrySelect.getTodayCases()));
        model.addAttribute("hojeObitos", NumberFormat.getIntegerInstance().format(countrySelect.getTodayDeaths()));
        model.addAttribute("hojeRecuperados", NumberFormat.getIntegerInstance().format(countrySelect.getTodayRecovered()));
        
        if(countrySelect.getCasesPerOneMillion() >= 50000){
       	 	model.addAttribute("situacao", "Alta");	
       	 	model.addAttribute("cor", "red");	

        } else if(countrySelect.getCasesPerOneMillion() >= 40000){
       	 	model.addAttribute("situacao", "Constante");
       	 	model.addAttribute("cor", "#F5CA7B");	

        } else {
       	 	model.addAttribute("situacao", "Baixo");	
       	 	model.addAttribute("cor", "#5BC1AE");	

        }
        
        return "index";
    }
	
}
