package com.lotdiz.deliveryservice.service;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryDetailResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.exception.DeliveryEntityNotFoundException;
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
  public void createDelivery(CreateDeliveryRequestDto createDeliveryRequestDto) {
    deliveryRepository.save(createDeliveryRequestDto.toEntity());
  }

  public GetDeliveryDetailResponseDto getDeliveryDetail(Long fundingId) {
    Delivery findDelivery =
        deliveryRepository
            .findByFundingId(fundingId)
            .orElseThrow(DeliveryEntityNotFoundException::new);
    return GetDeliveryDetailResponseDto.fromEntity(findDelivery);
  }
}
