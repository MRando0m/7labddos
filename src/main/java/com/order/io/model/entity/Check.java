package com.order.io.model.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("CHECK")
@Data
@EqualsAndHashCode(callSuper = true)
public class Check extends Payment {
    @Column(name = "check_name")
    private String name;

    @Column(name = "bank_id")
    private String bankID;
}
