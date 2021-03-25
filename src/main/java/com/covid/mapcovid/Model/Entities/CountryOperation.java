package com.covid.mapcovid.Model.Entities;

import com.covid.mapcovid.Model.Enums.Countries;
import com.covid.mapcovid.Model.Services.JsonCountry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class CountryOperation {

    public static Country GetCountry(Countries country){
        Country countryVar = new Country();

        Gson gson = new GsonBuilder().create();
        try {
            countryVar = gson.fromJson(JsonCountry.GetCountry(country), Country.class);
        }catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return countryVar;
    }


    public static long GetTotalCases(Countries country){
        return GetCountry(country).getCases();
    }

}
