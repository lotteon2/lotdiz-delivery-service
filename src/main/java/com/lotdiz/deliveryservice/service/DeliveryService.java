package com.lotdiz.deliveryservice.service;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.response.CreateDeliveryResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeliveryService {

  private final DeliveryRepository deliveryRepository;

  @Transactional
  public CreateDeliveryResponseDto createDelivery(
      Long fundingId, CreateDeliveryRequestDto createDeliveryRequestDto) {
    Delivery savedDelivery = deliveryRepository.save(createDeliveryRequestDto.toEntity(fundingId));
    return CreateDeliveryResponseDto.fromEntity(savedDelivery);
  }
}
