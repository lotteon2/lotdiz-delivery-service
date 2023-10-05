package com.lotdiz.deliveryservice.dto.response;

import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.entity.DeliveryStatus;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateDeliveryResponseDto {

  private Long deliveryId;
  private String deliveryRecipientName;
  private String deliveryRecipientPhoneNumber;
  private String deliveryRecipientEmail;
  private String deliveryRoadName;
  private String deliveryAddressDetail;
  private String deliveryZipCode;
  private String deliveryRequest;
  private Long deliveryCost;
  private DeliveryStatus deliveryStatus;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public static CreateDeliveryResponseDto of(Delivery delivery) {
    return CreateDeliveryResponseDto.builder()
        .deliveryId(delivery.getId())
        .deliveryRecipientName(delivery.getDeliveryRecipientName())
        .deliveryRecipientPhoneNumber(delivery.getDeliveryRecipientPhoneNumber())
        .deliveryRecipientEmail(delivery.getDeliveryRecipientEmail())
        .deliveryRoadName(delivery.getDeliveryRoadName())
        .deliveryAddressDetail(delivery.getDeliveryAddressDetail())
        .deliveryZipCode(delivery.getDeliveryZipCode())
        .deliveryRequest(delivery.getDeliveryRequest())
        .deliveryCost(delivery.getDeliveryCost())
        .deliveryStatus(delivery.getDeliveryStatus())
        .createdAt(delivery.getCreatedAt())
        .updatedAt(delivery.getUpdatedAt())
        .build();
  }
}
