package com.example.fund.service.impl;

import com.example.fund.model.entity.CollectionBox;
import com.example.fund.model.exception.ResourseNotFoundException;
import com.example.fund.model.response.CollectionBoxResponse;
import com.example.fund.repository.CollectionBoxRepository;
import com.example.fund.service.CollectionBoxService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollectionBoxServiceImpl implements CollectionBoxService {

    private final CollectionBoxRepository collectionBoxRepository;
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

    public static CollectionBoxResponse toResponse(CollectionBox box) {
        return CollectionBoxResponse.builder()
                .id(box.getId())
                .isAssigned(!Objects.isNull(box.getEvent()))
                .build();
    }
}
