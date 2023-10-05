package com.lotdiz.deliveryservice.repository;

import com.lotdiz.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {}
