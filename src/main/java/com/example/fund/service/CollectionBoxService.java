package com.example.fund.service;

import com.example.fund.model.request.CollectionBoxAssignRequest;
import com.example.fund.model.request.TransferRequest;
import com.example.fund.model.response.CollectionBoxResponse;

import java.util.List;
import java.util.UUID;

public interface CollectionBoxService {

    List<CollectionBoxResponse> getCollectionBoxes();

    CollectionBoxResponse createCollectionBox();

    void deleteCollectionBox(UUID id);

    boolean assignToFundraisingEvent(UUID id, CollectionBoxAssignRequest request);

    boolean transferMoney(TransferRequest request);
}
