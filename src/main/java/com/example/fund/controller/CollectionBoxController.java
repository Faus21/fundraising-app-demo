package com.example.fund.controller;

import com.example.fund.model.request.CollectionBoxAssignRequest;
import com.example.fund.model.request.TransferRequest;
import com.example.fund.model.request.TransferToEventRequest;
import com.example.fund.service.CollectionBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/transfer-box")
    public ResponseEntity<?> transferToCollectionBox(@RequestBody TransferRequest request) {
        return ResponseEntity.ok(collectionBoxService.transferMoney(request));
    }

    @PostMapping("/transfer-event")
    public ResponseEntity<?> transferToEvent(@RequestBody TransferToEventRequest request) {
        return ResponseEntity.ok(collectionBoxService.transferAllMoneyToEvent(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> assignCollectionBoxToFundraisingEvent(
            @PathVariable UUID id, @RequestBody CollectionBoxAssignRequest assignRequest) {
        return ResponseEntity.ok(collectionBoxService.assignToFundraisingEvent(id, assignRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCollectionBox(@PathVariable UUID id) {
        collectionBoxService.deleteCollectionBox(id);
        return ResponseEntity.noContent().build();
    }
}
