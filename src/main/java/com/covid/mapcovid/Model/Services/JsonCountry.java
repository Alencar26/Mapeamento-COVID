package com.covid.mapcovid.Model.Services;

import com.covid.mapcovid.Model.Enums.Countries;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonCountry {

    public static String GetCountry(Countries country) throws IOException, InterruptedException {

        final String URL_POST = "https://corona.lmao.ninja/v2/countries/" + country + "?yesterday&strict&query";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL_POST))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }
    

}
