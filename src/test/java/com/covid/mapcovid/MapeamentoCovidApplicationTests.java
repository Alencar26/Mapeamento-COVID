package com.covid.mapcovid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest
class MapeamentoCovidApplicationTests {

	@Test
	void ConsumerAPITest() throws IOException, InterruptedException {

		final String URL_POST = "https://corona.lmao.ninja/v2/countries/Paraguay?yesterday&strict&query";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(URL_POST))
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		String r = response.body();
		System.out.println(r);

	}

}
