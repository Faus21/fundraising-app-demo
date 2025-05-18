package com.example.fund.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "fundraising_event")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FundraisingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "fund_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "account_currency", nullable = false, length = 3)
    private String accountCurrency;
}
