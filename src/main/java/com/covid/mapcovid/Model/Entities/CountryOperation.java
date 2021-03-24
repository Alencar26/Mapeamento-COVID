package com.covid.mapcovid.Model.Entities;

import com.covid.mapcovid.Model.Enums.Countries;
import com.covid.mapcovid.Model.Services.JsonCountry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class CountryOperation {

    public static long GetTotalCases(Countries country){
        long cases = 0;
        Gson gson = new GsonBuilder().create();
        try {
            Country countryVar = gson.fromJson(JsonCountry.GetCountry(country), Country.class);
            cases = countryVar.getCases();
        }catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return cases;
    }

}
