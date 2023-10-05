package com.lotdiz.deliveryservice.dto.request;

import com.lotdiz.deliveryservice.entity.Delivery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    return Delivery.builder()
        .fundingId(fundingId)
        .deliveryRecipientName(this.deliveryRecipientName)
        .deliveryRecipientPhoneNumber(this.deliveryRecipientPhoneNumber)
        .deliveryRecipientEmail(this.deliveryRecipientEmail)
        .deliveryRoadName(this.deliveryRoadName)
        .deliveryAddressDetail(this.deliveryAddressDetail)
        .deliveryZipCode(this.deliveryZipCode)
        .deliveryRequest(this.deliveryRequest)
        .deliveryCost(this.deliveryCost)
        .build();
  }
}
