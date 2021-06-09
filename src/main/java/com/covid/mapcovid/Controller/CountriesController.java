package com.covid.mapcovid.Controller;

import com.covid.mapcovid.Model.Entities.Country;
import com.covid.mapcovid.Model.Entities.CountryOperation;
import com.covid.mapcovid.Model.Entities.CovidData;
import com.covid.mapcovid.Model.Entities.Request;
import com.covid.mapcovid.useCase.CovidDataUseCase;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.event.EventListener;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public Country countryChangeJSON(@RequestBody Request request, HttpServletRequest httpRequest) {
    		
		System.out.println(request.getName());
						
		HttpSession httpSession = httpRequest.getSession(false);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.DATE, -1);
	    Date yesterday = calendar.getTime();
	    String data = dateFormat.format(yesterday).toString();
	
		List<CovidData> lista = (List<CovidData>) httpSession.getAttribute("ListaCovid");
		
		List<CovidData> covidData =  lista.stream().filter(covid -> covid.getLocation().equals(request.getName())).collect(Collectors.toList());
				
   	 	Country countrySelect = CountryOperation.GetCountry(request.getName());
   	 	countrySelect.setCovidData(covidData);

		return countrySelect;
	}

}
