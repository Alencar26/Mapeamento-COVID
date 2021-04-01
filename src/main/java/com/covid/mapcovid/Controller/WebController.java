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
		
   	 	model.addAttribute("nomePais", "América do Sul");	
        model.addAttribute("totalCasos", NumberFormat.getIntegerInstance().format(continentSelect.getCases()));
        model.addAttribute("totalAtivos", NumberFormat.getIntegerInstance().format(continentSelect.getActive()));
        model.addAttribute("totalObitos", NumberFormat.getIntegerInstance().format(continentSelect.getDeaths()));
        model.addAttribute("totalRecuperados", NumberFormat.getIntegerInstance().format(continentSelect.getRecovered()));
        model.addAttribute("totalTestes", NumberFormat.getIntegerInstance().format(continentSelect.getTests()));
        model.addAttribute("totalCriticos", NumberFormat.getIntegerInstance().format(continentSelect.getCritical()));
        model.addAttribute("populacao",  NumberFormat.getIntegerInstance().format(continentSelect.getPopulation()));
        model.addAttribute("hojeCasos", NumberFormat.getIntegerInstance().format(continentSelect.getTodayCases()));
        model.addAttribute("hojeObitos", NumberFormat.getIntegerInstance().format(continentSelect.getTodayDeaths()));
        model.addAttribute("hojeRecuperados", NumberFormat.getIntegerInstance().format(continentSelect.getTodayRecovered()));
        
        if(continentSelect.getCasesPerOneMillion() >= 50000){
       	 	model.addAttribute("situacao", "Alta");	
       	 	model.addAttribute("cor", "red");	

        } else if(continentSelect.getCasesPerOneMillion() >= 40000){
       	 	model.addAttribute("situacao", "Constante");
       	 	model.addAttribute("cor", "#F5CA7B");	

        } else {
       	 	model.addAttribute("situacao", "Baixo");	
       	 	model.addAttribute("cor", "#5BC1AE");	

        }
        
        return "index";
    }
	
}
