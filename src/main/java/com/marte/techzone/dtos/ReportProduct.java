package com.marte.techzone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProduct {

    private String brandName;
    private Double averagePrices;
    private BigDecimal sumPrices;

}
