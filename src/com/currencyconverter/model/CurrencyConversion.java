package com.currencyconverter.model;

public class CurrencyConversion {
    private final String fromCurrency;
    private final String toCurrency;
    private final double amount;
    private final double convertedAmount;

    public CurrencyConversion(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    @Override
    public String toString() {
        return String.format("Valor %.2f [%s] corresponde ao valor final de >>> %.2f [%s]",
                amount, fromCurrency, convertedAmount, toCurrency);
    }
}
