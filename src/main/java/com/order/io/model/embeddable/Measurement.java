package com.order.io.model.embeddable;

import lombok.Data;
import jakarta.persistence.Embeddable;

@Embeddable
@Data
public class Measurement {
    private String name;
    private String symbol;
}
