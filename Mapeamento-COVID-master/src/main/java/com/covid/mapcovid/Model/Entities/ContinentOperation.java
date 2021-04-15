package com.covid.mapcovid.Model.Entities;

import com.covid.mapcovid.Model.Services.JsonContinent;
import java.io.IOException;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContinentOperation {

	
	    public static Continent GetContinent(String continent){
	        Continent continentVar = new Continent();

	        Gson gson = new GsonBuilder().create();
	        try {
	            continentVar = gson.fromJson(JsonContinent.GetContinent(continent), Continent.class);
	        }catch (IOException | InterruptedException e) {
	            System.out.println(e.getMessage());
	        }
	        return continentVar;
	    }

	  

	}

	

