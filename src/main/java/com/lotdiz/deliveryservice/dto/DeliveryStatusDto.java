package com.lotdiz.deliveryservice.dto;

import com.lotdiz.deliveryservice.entity.DeliveryStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DeliveryStatusDto {
     private Long fundingId;
  private String deliveryStatus;

  public static String getDeliveryStatusToString(DeliveryStatus deliveryStatus) {
    switch (deliveryStatus) {
      case PENDING:
        return "배송 준비 중";
      case CANCELED:
        return "배송 취소";
      case COMPLETED:
        return "배송 완료";
      case PROCESSING:
        return "배송 중";
    }
    return null;
  }
}
