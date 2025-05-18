package com.example.fund.controller;

import com.example.fund.model.entity.CollectionBox;
import com.example.fund.service.CollectionBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/collection-box")
@RequiredArgsConstructor
public class CollectionBoxController {

    private final CollectionBoxService collectionBoxService;

    @GetMapping
    public ResponseEntity<?> getCollectionBoxes() {
        return ResponseEntity.ok(collectionBoxService.getCollectionBoxes());
    }

    @PostMapping
    public ResponseEntity<?> createCollectionBox() {
        return ResponseEntity.ok(collectionBoxService.createCollectionBox());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCollectionBox(@PathVariable UUID id) {
        collectionBoxService.deleteCollectionBox(id);
        return ResponseEntity.noContent().build();
    }
}
