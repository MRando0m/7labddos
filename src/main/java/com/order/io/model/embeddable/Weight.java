package com.order.io.model.embeddable;

import jakarta.persistence.Column;
import lombok.Data;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Data
public class Weight {
    @Column(name = "value")
    private BigDecimal value;
}