package com.example.fund.controller;

import com.example.fund.model.request.FundraisingEventCreateRequest;
import com.example.fund.service.FundraisingEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fundraising-event")
@RequiredArgsConstructor
public class FundraisingEventController {

    private final FundraisingEventService fundraisingEventService;

    @GetMapping
    public ResponseEntity<?> getFundraisingEvents() {
        return ResponseEntity.ok(fundraisingEventService.getFundraisingEvents());
    }

    @PostMapping
    public ResponseEntity<?> registerFundraisingEvent(@RequestBody
                                                          FundraisingEventCreateRequest request) {
        return ResponseEntity.ok(fundraisingEventService.createFundraisingEvent(request));
    }
}
