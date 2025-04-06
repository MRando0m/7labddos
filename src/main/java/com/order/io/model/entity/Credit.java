package com.order.io.model.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("CREDIT")
@Data
@EqualsAndHashCode(callSuper = true)
public class Credit extends Payment {
    @Column(name = "credit_number")
    private String number;

    @Column(name = "credit_type")
    private String type;

    @Column(name = "exp_date")
    private LocalDateTime expDate;
}