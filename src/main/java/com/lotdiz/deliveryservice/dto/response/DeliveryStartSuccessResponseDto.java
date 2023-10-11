package com.lotdiz.deliveryservice.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeliveryStartSuccessResponseDto {
  private String deliveryStatusToProcessing;
}
