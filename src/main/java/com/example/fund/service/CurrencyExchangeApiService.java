package com.example.fund.service;

import java.math.BigDecimal;

public interface CurrencyExchangeApiService {
    BigDecimal getExchangeRate(String fromCurrency, String toCurrency, BigDecimal amount);
}
