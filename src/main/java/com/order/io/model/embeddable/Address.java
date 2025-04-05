package com.order.io.model.embeddable;

import lombok.Data;
import jakarta.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String city;
    private String street;
    private String zipcode;
}