package com.javaacademy.car_avito;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Advert {
    private int id;
    private String brand;
    private String color;
    private BigDecimal price;
}
