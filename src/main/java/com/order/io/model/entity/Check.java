package com.order.io.model.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CHECK")
@Data
public class Check extends Payment {
    private String name;
    private String bankID;
}
