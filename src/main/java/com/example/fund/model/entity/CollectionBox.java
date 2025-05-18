package com.example.fund.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "collection_box")
@Getter
@Setter
@RequiredArgsConstructor
public class CollectionBox {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "collection_box_id")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "fund_id")
    private FundraisingEvent event;
}
