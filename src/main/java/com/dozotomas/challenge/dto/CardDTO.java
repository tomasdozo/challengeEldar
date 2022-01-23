package com.dozotomas.challenge.dto;

import com.dozotomas.challenge.model.Brand;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardDTO {
    private String brand;
    private String value;
}
