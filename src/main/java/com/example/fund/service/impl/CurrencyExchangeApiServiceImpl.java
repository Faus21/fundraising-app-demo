package com.example.fund.service.impl;

import com.example.fund.config.ExchangeProperties;
import com.example.fund.service.CurrencyExchangeApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeApiServiceImpl implements CurrencyExchangeApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ExchangeProperties exchangeProperties;

    @Override
    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency, BigDecimal amount) {
        URI uri = UriComponentsBuilder
                .fromUriString(exchangeProperties.getUrl())
                .pathSegment("64cc62dd64bac701646a68e0")
                .pathSegment("pair")
                .pathSegment(fromCurrency)
                .pathSegment(toCurrency)
                .pathSegment(amount.toString())
                .build()
                .toUri();

        Map response = restTemplate.getForObject(uri, Map.class);

        if (response != null && response.get("result").equals("success")) {
            return new BigDecimal(response.get("conversion_result").toString());
        } else {
            throw new RuntimeException("Currency conversion failed: " + response);
        }
    }
}
