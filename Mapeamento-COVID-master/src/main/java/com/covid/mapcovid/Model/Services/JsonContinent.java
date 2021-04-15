package com.covid.mapcovid.Model.Services;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonContinent {

	

	    public static String GetContinent(String continent) throws IOException, InterruptedException {

	    	System.out.println(continent);
	    	
	        final String URL_POST = "https://corona.lmao.ninja/v2/continents/" + continent + "?yesterday&strict&query";

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .GET()
	                .uri(URI.create(URL_POST))
	                .build();

	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	        return response.body();

	    }
	    

	}
	
	

