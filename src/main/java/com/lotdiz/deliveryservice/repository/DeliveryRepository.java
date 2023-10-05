package com.lotdiz.deliveryservice.repository;

import com.lotdiz.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
  Optional<Delivery> findByFundingId(@Param("fundingId") Long fundingId);
}
