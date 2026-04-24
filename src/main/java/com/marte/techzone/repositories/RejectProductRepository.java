package com.marte.techzone.repositories;

import com.marte.techzone.entities.RejectProductEntity;
import com.marte.techzone.entities.RejectProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RejectProductRepository extends JpaRepository<RejectProductEntity, RejectProductId> {
}
