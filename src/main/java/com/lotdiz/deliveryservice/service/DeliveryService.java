package com.lotdiz.deliveryservice.service;

import com.lotdiz.deliveryservice.dto.DeliveryStatusDto;
import com.lotdiz.deliveryservice.dto.DeliveryStatusOfFundingDto;
import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.request.InformationForDeliveryStartNotificationRequestDto;
import com.lotdiz.deliveryservice.dto.response.DeliveryStatusResponseDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryResponseDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryStatusResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.exception.DeliveryEntityNotFoundException;
import com.lotdiz.deliveryservice.repository.DeliveryRepository;
<<<<<<< HEAD
import java.util.ArrayList;
=======

>>>>>>> origin/develop
import java.util.List;
import java.util.stream.Collectors;

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

    public GetDeliveryResponseDto getDelivery(Long fundingId) {
        Delivery findDelivery =
                deliveryRepository
                        .findByFundingId(fundingId)
                        .orElseThrow(DeliveryEntityNotFoundException::new);
        return GetDeliveryResponseDto.fromEntity(findDelivery);
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
    List<DeliveryStatusOfFundingDto> deliveryStatus =
        deliveryRepository.findDeliveryStatus(fundingId);
    List<DeliveryStatusDto> response = new ArrayList<>();
    deliveryStatus.forEach(
        item ->
            response.add(
                DeliveryStatusDto.builder()
                    .fundingId(item.getFundingId())
                    .deliveryStatus(
                        DeliveryStatusDto.getDeliveryStatusToString(item.getDeliveryStatus()))
                    .build()));
    return DeliveryStatusResponseDto.builder().deliveryStatusOfFundingDtos(response).build();
  }

    public List<GetDeliveryStatusResponseDto> getDeliveryStatusByFundingIds(List<Long> fundingIds) {
        return deliveryRepository.findAllByFundingIdIsIn(fundingIds)
                .stream().map(d -> GetDeliveryStatusResponseDto.builder().fundingId(d.getFundingId())
                        .deliveryStatus(d.getDeliveryStatus()).build())
                .collect(Collectors.toList());
    }
}
