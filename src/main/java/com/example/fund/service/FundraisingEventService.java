package com.example.fund.service;

import com.example.fund.model.request.FundraisingEventCreateRequest;
import com.example.fund.model.response.FundraisingEventResponse;

import java.util.List;

public interface FundraisingEventService {
    List<FundraisingEventResponse> getFundraisingEvents();
    FundraisingEventResponse createFundraisingEvent(FundraisingEventCreateRequest request);
}
