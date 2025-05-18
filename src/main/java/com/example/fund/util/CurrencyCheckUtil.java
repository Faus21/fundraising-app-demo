package com.example.fund.util;

import java.util.ArrayList;
import java.util.List;

public class CurrencyCheckUtil {

    private static final List<String> currencies = new ArrayList<>(List.of("USD", "EUR", "PLN"));

    public static boolean checkCurrency(String currency) {
        return currencies.contains(currency);
    }
}
