package com.covid.mapcovid.Controller;

import java.text.NumberFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.covid.mapcovid.Model.Entities.Continent;
import com.covid.mapcovid.Model.Entities.ContinentOperation;
import com.covid.mapcovid.Model.Entities.Country;
import com.covid.mapcovid.Model.Entities.CountryOperation;
import com.covid.mapcovid.Model.Entities.CovidData;
import com.covid.mapcovid.Model.Enums.Countries;
import com.covid.mapcovid.useCase.CovidDataUseCase;

@Controller
public class WebController {
	
	@GetMapping({"/"})
    public String index(Model model, HttpSession httpSession) throws InterruptedException  {
    	
		if(httpSession.getAttribute("ListaCovid") == null){
			httpSession.setAttribute("ListaCovid", new CovidDataUseCase().execute());
		}
		
		Continent continentSelect = ContinentOperation.GetContinent("South%20America");
		
		System.out.println(continentSelect);
		
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
        
   	 	model.addAttribute("situacao", NumberFormat.getIntegerInstance().format(continentSelect.getCasesPerOneMillion()));	
   	 	model.addAttribute("cor", "white");	
           	 	
        return "index";
    }
	
}
