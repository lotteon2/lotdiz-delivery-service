package com.lotdiz.deliveryservice.dto.response;

import com.lotdiz.deliveryservice.entity.DeliveryStatus;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetDeliveryStatusResponseDto {

    private Long fundingId;
    private DeliveryStatus deliveryStatus;
}
