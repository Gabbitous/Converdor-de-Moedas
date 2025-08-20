package com.currencyconverter.service;

import com.currencyconverter.model.ExchangeRateResponse;
import com.currencyconverter.model.CurrencyConversion;
import java.io.IOException;

public class CurrencyConverter {
    private final ExchangeRateService exchangeRateService;

    public CurrencyConverter(String apiKey) {
        this.exchangeRateService = new ExchangeRateService(apiKey);
    }

    public CurrencyConversion convert(String fromCurrency, String toCurrency, double amount) throws IOException, InterruptedException {
        ExchangeRateResponse response = exchangeRateService.getExchangeRates(fromCurrency);
        if (response != null && response.getConversionRates() != null) {
            Double rate = response.getConversionRates().get(toCurrency);
            if (rate != null) {
                double convertedAmount = amount * rate;
                return new CurrencyConversion(fromCurrency, toCurrency, amount, convertedAmount);
            } else {
                throw new IllegalArgumentException("Taxa de conversão não encontrada para " + toCurrency);
            }
        } else {
            throw new IOException("Não foi possível obter as taxas de câmbio.");
        }
    }
}
