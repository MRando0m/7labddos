package com.order.io.model.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("CREDIT")
@Data
public class Credit extends Payment {
    private String number;
    private String type;
    private LocalDateTime expDate;
}