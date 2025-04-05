package com.order.io.model.entity;

import com.order.io.model.embeddable.Weight;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Weight shippingWeight;
    private String description;
}