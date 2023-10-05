package com.lotdiz.deliveryservice.controller.clientcontroller;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.response.CreateDeliveryResponseDto;
import com.lotdiz.deliveryservice.service.DeliveryService;
import com.lotdiz.deliveryservice.utils.SuccessResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryClientController {

  private final DeliveryService deliveryService;

  @PostMapping(value = "/fundings/{fundingId}/delivery")
  public ResponseEntity<SuccessResponse> createDelivery(
      @PathVariable("fundingId") Long fundingId,
      @Valid @RequestBody CreateDeliveryRequestDto createDeliveryRequestDto) {
    CreateDeliveryResponseDto createDeliveryResponseDto =
        deliveryService.createDelivery(fundingId, createDeliveryRequestDto);
    return ResponseEntity.ok()
        .body(
            SuccessResponse.builder()
                .code(HttpStatus.OK.toString())
                .message(HttpStatus.OK.name())
                .detail("배송 생성 성공")
                .data(createDeliveryResponseDto)
                .build());
  }
}
