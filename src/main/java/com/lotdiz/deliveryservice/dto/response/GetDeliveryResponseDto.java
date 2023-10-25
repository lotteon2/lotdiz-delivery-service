package com.lotdiz.deliveryservice.dto.response;

import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.entity.DeliveryStatus;
import com.lotdiz.deliveryservice.mapper.DeliveryMapper;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetDeliveryResponseDto {

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

  public static GetDeliveryResponseDto fromEntity(Delivery delivery) {
    return DeliveryMapper.INSTANCE.deliveryToGetDeliveryDetailResponseDto(delivery);
  }
}
