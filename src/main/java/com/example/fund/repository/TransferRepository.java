package com.example.fund.repository;

import com.example.fund.model.entity.TransferCollectionBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferRepository extends JpaRepository<TransferCollectionBox, UUID> {
}
