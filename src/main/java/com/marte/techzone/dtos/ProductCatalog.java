package com.marte.techzone.dtos;

import com.marte.techzone.entities.CodeCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCatalog {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<CategoryDto> categories;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CategoryDto {
        private CodeCategoryEnum code;
        private String description;
    }

}
