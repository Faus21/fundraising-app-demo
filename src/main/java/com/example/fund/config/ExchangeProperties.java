package com.example.fund.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "external.exchange")
@Getter
@Setter
public class ExchangeProperties {

    private String url;

}