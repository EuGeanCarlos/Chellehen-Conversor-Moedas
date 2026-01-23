package org.example.service;

import com.google.gson.Gson;
import org.example.model.ExchangeRateResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {

    private static final String API_KEY =
            System.getenv("EXCHANGE_RATE_API_KEY");

    private static final String BASE_URL =
            "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public ExchangeRateResponse convert(
            String from,
            String to,
            double amount
    ) {

        if (API_KEY == null || API_KEY.isBlank()) {
            throw new RuntimeException(
                    "API key não informada. Configure a variável de ambiente EXCHANGE_RATE_API_KEY."
            );
        }

        String url = BASE_URL + API_KEY + "/pair/"
                + from + "/" + to + "/" + amount;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro ao acessar a API: HTTP "
                        + response.statusCode());
            }

            return gson.fromJson(
                    response.body(),
                    ExchangeRateResponse.class
            );

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro na comunicação com a API", e);
        }
    }
}
