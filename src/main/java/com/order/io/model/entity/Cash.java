package com.order.io.model.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("CASH")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cash extends Payment {
    @Column(precision = 10, scale = 2)
    private BigDecimal cashTendered;
}