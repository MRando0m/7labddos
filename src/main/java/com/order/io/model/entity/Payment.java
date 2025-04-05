package com.order.io.model.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_type")
@Data
public abstract class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;
    private boolean paid;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}