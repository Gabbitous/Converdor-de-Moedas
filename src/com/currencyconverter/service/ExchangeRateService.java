package com.currencyconverter.service;

import com.currencyconverter.model.ExchangeRateResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey;
    private final Gson gson;

    public ExchangeRateService(String apiKey) {
        this.apiKey = apiKey;
        this.gson = new Gson();
    }

    public ExchangeRateResponse getExchangeRates(String baseCurrency) throws IOException, InterruptedException {
        String url = API_URL + apiKey + "/latest/" + baseCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return gson.fromJson(response.body(), ExchangeRateResponse.class);
        } else {
            throw new IOException("Erro ao obter taxas de câmbio: " + response.statusCode() + " - " + response.body());
        }
    }
}
