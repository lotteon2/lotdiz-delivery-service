package com.lotdiz.deliveryservice.repository;

import com.lotdiz.deliveryservice.dto.DeliveryStatusOfFundingDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
  Optional<Delivery> findByFundingId(@Param("fundingId") Long fundingId);

  @Query(
      "select new com.lotdiz.deliveryservice.dto.DeliveryStatusOfFundingDto(d.fundingId, d.deliveryStatus) from Delivery d")
  List<DeliveryStatusOfFundingDto> findDeliveryStatus(List<Long> fundingId);

  @Query("select d from Delivery d where d.fundingId in :fundingIds")
  List<Delivery> findAllByFundingIdIsIn(List<Long> fundingIds);
}
