package com.example.fund.service.impl;

import com.example.fund.model.entity.FundraisingEvent;
import com.example.fund.model.request.FundraisingEventCreateRequest;
import com.example.fund.model.response.FundraisingEventResponse;
import com.example.fund.repository.FundraisingEventRepository;
import com.example.fund.service.FundraisingEventService;
import com.example.fund.util.CurrencyCheckUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FundraisingEventServiceImpl implements FundraisingEventService {

    private final FundraisingEventRepository fundraisingEventRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FundraisingEventResponse> getFundraisingEvents() {
        return fundraisingEventRepository.findAll().stream()
                .map(en -> modelMapper.map(en, FundraisingEventResponse.class))
                .toList();
    }

    @Override
    public FundraisingEventResponse createFundraisingEvent(FundraisingEventCreateRequest request) {

        if (!CurrencyCheckUtil.checkCurrency(request.getAccountCurrency())){
            throw new IllegalArgumentException("Currencies don't match");
        }

        FundraisingEvent fundraisingEvent = modelMapper.map(request, FundraisingEvent.class);
        fundraisingEvent.setAmount(new BigDecimal(0));
        fundraisingEventRepository.save(fundraisingEvent);

        return modelMapper.map(fundraisingEvent, FundraisingEventResponse.class);
    }
}
