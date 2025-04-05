package com.order.io.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CHECK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Check extends Payment {
    private String name;
    private String bankId; // Исправлено: bankID → bankId
}
