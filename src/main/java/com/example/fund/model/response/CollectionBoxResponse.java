package com.example.fund.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CollectionBoxResponse {

    private UUID id;

    private boolean isEmpty;

    private boolean isAssigned;
}
