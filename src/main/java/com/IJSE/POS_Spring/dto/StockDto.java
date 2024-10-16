package com.IJSE.POS_Spring.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockDto {
    
    private Long itemId;
    
    private Long quantity;

    private String transctype;

    private LocalDateTime orderDateTime;
}
