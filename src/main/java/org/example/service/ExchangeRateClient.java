package org.example.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String apiKey;

    public ExchangeRateClient(String apiKey) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException(
                    "API key não informada. Configure a variável de ambiente EXCHANGE_RATE_API_KEY."
            );
        }
        this.apiKey = apiKey.trim();
    }

    public String getPairConversionJson(String from, String to, double amount)
            throws IOException, InterruptedException {

        String url = String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.4f",
                apiKey, from, to, amount
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Falha ao consultar API. HTTP " + response.statusCode());
        }

        return response.body();
    }
}
