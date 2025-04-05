package com.order.io.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CASH")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cash extends Payment {
    private float cashTendered;
}
