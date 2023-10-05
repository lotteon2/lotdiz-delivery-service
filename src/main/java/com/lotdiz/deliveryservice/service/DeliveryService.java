package com.lotdiz.deliveryservice.service;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.response.CreateDeliveryResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

  private final DeliveryRepository deliveryRepository;

  public CreateDeliveryResponseDto createDelivery(
      Long fundingId, CreateDeliveryRequestDto createDeliveryRequestDto) {
    Delivery savedDelivery = deliveryRepository.save(createDeliveryRequestDto.toEntity(fundingId));
    return CreateDeliveryResponseDto.of(savedDelivery);
  }
}
