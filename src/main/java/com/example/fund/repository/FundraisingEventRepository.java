package com.example.fund.repository;

import com.example.fund.model.entity.FundraisingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FundraisingEventRepository extends JpaRepository<FundraisingEvent, UUID> {
}
