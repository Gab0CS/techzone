package com.marte.techzone.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "reject_products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(RejectProductId.class)
public class RejectProductEntity {
    @Id
    private String productName;
    @Id
    private String brandName;

    private Integer quantity;

}
