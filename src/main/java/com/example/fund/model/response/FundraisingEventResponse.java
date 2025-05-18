package com.example.fund.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class FundraisingEventResponse {
    private UUID id;
    private String name;
    private BigDecimal amount;
    private String accountCurrency;
}
