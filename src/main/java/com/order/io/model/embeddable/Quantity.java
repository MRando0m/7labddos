package com.order.io.model.embeddable;

import lombok.Data;
import jakarta.persistence.Embeddable;

@Embeddable
@Data
public class Quantity {
    private Integer value;
}