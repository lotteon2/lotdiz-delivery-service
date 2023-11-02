package com.lotdiz.deliveryservice.dto.response;

import com.lotdiz.deliveryservice.dto.DeliveryStatusDto;
import com.lotdiz.deliveryservice.dto.DeliveryStatusOfFundingDto;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DeliveryStatusResponseDto {
  private List<DeliveryStatusDto> deliveryStatusOfFundingDtos;
}
