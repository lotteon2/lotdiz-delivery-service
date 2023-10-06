package com.lotdiz.deliveryservice.dto.request;

import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.mapper.DeliveryMapper;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateDeliveryRequestDto {

  private Long fundingId;
  private String deliveryRecipientName;
  private String deliveryRecipientPhoneNumber;
  private String deliveryRecipientEmail;
  private String deliveryRoadName;
  private String deliveryAddressDetail;
  private String deliveryZipCode;
  private String deliveryRequest;
  private Long deliveryCost;

  public Delivery toEntity() {
    return DeliveryMapper.INSTANCE.createDeliveryRequestDtoToDelivery(this);
  }
}
