package com.lotdiz.deliveryservice.dto.response;

import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.entity.DeliveryStatus;
import java.time.LocalDateTime;

import com.lotdiz.deliveryservice.mapper.DeliveryMapper;
import lombok.*;

@Getter
@Builder
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

  public static CreateDeliveryResponseDto fromEntity(Delivery delivery) {
    return DeliveryMapper.INSTANCE.deliveryToCreateDeliveryResponseDto(delivery);
  }
}
