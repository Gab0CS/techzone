package com.marte.techzone.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {

    private String id;
    private String clientRfc;
    private BigDecimal amount;
    @JsonIgnore //Avoid circular dependency
    private OrderDTO order;
}
