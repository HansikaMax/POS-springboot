package com.IJSE.POS_Spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private String name;

    private Double price;

    private String description;

    private Long categoryId;
}
