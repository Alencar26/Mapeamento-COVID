package com.covid.mapcovid.Model.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JSONChart {
	
	public static String GetHistorical(String country) throws IOException, InterruptedException {

    	System.out.println(country);
    	
        final String URL_POST = "https://disease.sh/v3/covid-19/historical/"+ country +"?lastdays=15";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL_POST))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }  

}
