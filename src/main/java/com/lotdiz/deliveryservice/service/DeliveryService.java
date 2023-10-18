package com.lotdiz.deliveryservice.service;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.request.InformationForDeliveryStartNotificationRequestDto;
import com.lotdiz.deliveryservice.dto.response.DeliveryStatusResponseDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryDetailResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.exception.DeliveryEntityNotFoundException;
import com.lotdiz.deliveryservice.repository.DeliveryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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

  @Transactional
  public Delivery modifyDeliveryStatus(
      InformationForDeliveryStartNotificationRequestDto
          informationForDeliveryStartNotificationRequestDto) {
    Delivery delivery =
        deliveryRepository
            .findByFundingId(informationForDeliveryStartNotificationRequestDto.getFundingId())
            .orElseThrow(DeliveryEntityNotFoundException::new);
    Delivery deliveryStatusToProcessing = delivery.modifyDeliveryStatusToProcessing();
    log.info("delivery status update to {}", delivery.getDeliveryStatus());
    return deliveryStatusToProcessing;
  }

  public DeliveryStatusResponseDto getDeliveryStatus(List<Long> fundingId) {
    return DeliveryStatusResponseDto.builder()
        .deliveryStatusOfFundingDtos(deliveryRepository.findDeliveryStatus(fundingId))
        .build();
  }
}
