package com.covid.mapcovid.Controller;

import com.covid.mapcovid.Model.Entities.CountryOperation;
import com.covid.mapcovid.Model.Enums.Countries;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountriesController {

    @GetMapping
    public String Cases(){
        return  "Casos no Brasil: " + CountryOperation.GetTotalCases(Countries.Brazil)+ "\n" +
                "Casos na Argentina: " + CountryOperation.GetTotalCases(Countries.Argentina)+ "\n" +
                "Casos no Peru: " + CountryOperation.GetTotalCases(Countries.Peru);
    }

}
