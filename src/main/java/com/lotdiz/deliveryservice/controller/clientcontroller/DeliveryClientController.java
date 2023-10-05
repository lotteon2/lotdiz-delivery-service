package com.lotdiz.deliveryservice.controller.clientcontroller;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.response.CreateDeliveryResponseDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryDetailResponseDto;
import com.lotdiz.deliveryservice.service.DeliveryService;
import com.lotdiz.deliveryservice.utils.SuccessResponse;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .data(Map.of("delivery", createDeliveryResponseDto))
                .build());
  }

  @GetMapping(value = "/fundings/{fundingId}/delivery")
  public ResponseEntity<SuccessResponse> getDeliveryDetail(
      @PathVariable("fundingId") Long fundingId) {
    GetDeliveryDetailResponseDto getDeliveryDetailResponseDto =
        deliveryService.getDeliveryDetail(fundingId);
    return ResponseEntity.ok()
        .body(
            SuccessResponse.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .detail("배송 조회 성공")
                .data(Map.of("delivery", getDeliveryDetailResponseDto))
                .build());
  }
}
