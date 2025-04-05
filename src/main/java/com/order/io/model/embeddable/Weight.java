package com.order.io.model.embeddable;

import lombok.Data;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Data
public class Weight {
    private BigDecimal value;
}