package com.example.fund.service;

import com.example.fund.model.response.CollectionBoxResponse;

import java.util.List;
import java.util.UUID;

public interface CollectionBoxService {

    List<CollectionBoxResponse> getCollectionBoxes();

    CollectionBoxResponse createCollectionBox();

    void deleteCollectionBox(UUID id);
}
