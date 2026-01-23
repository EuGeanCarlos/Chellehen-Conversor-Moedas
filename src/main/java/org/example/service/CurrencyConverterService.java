package org.example.service;

import com.google.gson.Gson;
import org.example.model.ExchangeRateResponse;

public class CurrencyConverterService {

    private final ExchangeRateClient client;
    private final Gson gson = new Gson();

    public CurrencyConverterService(ExchangeRateClient client) {
        this.client = client;
    }

    public ExchangeRateResponse convert(String from, String to, double amount) throws Exception {
        String json = client.getPairConversionJson(from, to, amount);
        ExchangeRateResponse resp = gson.fromJson(json, ExchangeRateResponse.class);

        if (resp == null || resp.result == null) {
            throw new Exception("Resposta inválida da API.");
        }

        if (!"success".equalsIgnoreCase(resp.result)) {
            String err = (resp.error_type != null) ? resp.error_type : "erro_desconhecido";
            throw new Exception("API retornou erro: " + err);
        }

        return resp;
    }
}
