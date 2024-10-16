package com.IJSE.POS_Spring.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PosDto {
    private List<Long> itemIds;

    private Double totalPrice;

    private LocalDateTime PosDateTime;
}
