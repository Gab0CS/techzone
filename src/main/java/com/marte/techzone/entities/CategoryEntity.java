package com.marte.techzone.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CodeCategoryEnum code;

    private String description;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<ProductCatalogEntity> productsCatalogs;
}
