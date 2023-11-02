package com.lotdiz.deliveryservice.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetDeliveryStatusRequestDto {

    private List<Long> fundingIds;
}
