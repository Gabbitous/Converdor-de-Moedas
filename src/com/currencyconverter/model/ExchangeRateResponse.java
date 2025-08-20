package com.currencyconverter.model;

import java.util.Map;

public class ExchangeRateResponse {
    private final Map<String, Double> conversion_rates;

    public ExchangeRateResponse(Map<String, Double> conversionRates) {
        conversion_rates = conversionRates;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

}
