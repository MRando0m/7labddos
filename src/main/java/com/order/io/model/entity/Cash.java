package com.order.io.model.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CASH")
@Data
public class Cash extends Payment {
    private float cashTendered;
}