package com.example.fund.service.impl;

import com.example.fund.model.entity.CollectionBox;
import com.example.fund.model.entity.FundraisingEvent;
import com.example.fund.model.entity.TransferCollectionBox;
import com.example.fund.model.exception.ResourseNotFoundException;
import com.example.fund.model.request.CollectionBoxAssignRequest;
import com.example.fund.model.request.TransferRequest;
import com.example.fund.model.response.CollectionBoxResponse;
import com.example.fund.repository.CollectionBoxRepository;
import com.example.fund.repository.FundraisingEventRepository;
import com.example.fund.repository.TransferRepository;
import com.example.fund.service.CollectionBoxService;
import com.example.fund.util.CurrencyCheckUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollectionBoxServiceImpl implements CollectionBoxService {

    private final CollectionBoxRepository collectionBoxRepository;
    private final FundraisingEventRepository fundraisingEventRepository;
    private final TransferRepository transferRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CollectionBoxResponse> getCollectionBoxes() {
        return collectionBoxRepository.findAll().stream()
                .map(CollectionBoxServiceImpl::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CollectionBoxResponse createCollectionBox() {
        CollectionBox collectionBox = new CollectionBox();

        collectionBoxRepository.save(collectionBox);

        return toResponse(collectionBox);
    }

    @Override
    public void deleteCollectionBox(UUID id) {
        CollectionBox collectionBox = collectionBoxRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Collection box not found"));

        collectionBoxRepository.delete(collectionBox);
    }

    @Transactional
    @Override
    public boolean assignToFundraisingEvent(UUID id, CollectionBoxAssignRequest request) {
        if(Objects.isNull(request.getId()))
            throw new IllegalArgumentException("Fundraising event id is null");

        CollectionBox box = collectionBoxRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Collection box not found"));

        FundraisingEvent event = fundraisingEventRepository.findById(request.getId())
                .orElseThrow(() -> new ResourseNotFoundException("Fundraising event not found"));

        if (!Objects.isNull(box.getEvent()))
            throw new IllegalArgumentException("Collection box is already assigned to event");

        box.setEvent(event);

        return true;
    }

    @Transactional
    @Override
    public boolean transferMoney(TransferRequest request) {
        CollectionBox box = collectionBoxRepository.findById(request.getCollectionBox())
                .orElseThrow(() -> new ResourseNotFoundException("Collection box not found"));

        if (!CurrencyCheckUtil.checkCurrency(request.getCurrency()))
            throw new IllegalArgumentException("Incorrect currency");

        TransferCollectionBox transferCollectionBox = modelMapper.map(request, TransferCollectionBox.class);
        transferCollectionBox.setCollectionBox(box);

        transferRepository.save(transferCollectionBox);

        return true;
    }

    public static CollectionBoxResponse toResponse(CollectionBox box) {
        return CollectionBoxResponse.builder()
                .id(box.getId())
                .isAssigned(!Objects.isNull(box.getEvent()))
                .isEmpty(box.getTransfers().isEmpty())
                .build();
    }
}
