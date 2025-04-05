package com.order.io.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("CREDIT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit extends Payment {
    private String number;
    private String type;
    private LocalDateTime expDate;
}
