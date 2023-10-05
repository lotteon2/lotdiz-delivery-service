package com.lotdiz.deliveryservice.dto.request;

import com.lotdiz.deliveryservice.entity.Delivery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lotdiz.deliveryservice.mapper.DeliveryMapper;
import lombok.*;

@Getter
@Builder
public class CreateDeliveryRequestDto {

  @NotBlank(message = "deliveryRecipientName cannot be blank")
  private String deliveryRecipientName;

  @NotBlank(message = "deliveryRecipientPhoneNumber cannot be blank")
  private String deliveryRecipientPhoneNumber;

  private String deliveryRecipientEmail;

  @NotBlank(message = "deliveryRoadName cannot be blank")
  private String deliveryRoadName;

  @NotBlank(message = "deliveryAddressDetail cannot be blank")
  private String deliveryAddressDetail;

  @NotBlank(message = "deliveryZipCode cannot be blank")
  private String deliveryZipCode;

  private String deliveryRequest;

  @NotNull(message = "deliveryCost cannot be null")
  private Long deliveryCost;

  public Delivery toEntity(Long fundingId) {
    Delivery delivery = DeliveryMapper.INSTANCE.createDeliveryRequestDtoToDelivery(this);
    delivery.setFundingId(fundingId);
    return delivery;
  }
}
