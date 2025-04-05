package com.order.io.model.entity;

import com.order.io.model.embeddable.Quantity;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Quantity quantity;
    private String taxStatus;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
