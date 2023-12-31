package com.lotdiz.deliveryservice.controller.clientcontroller;

import com.lotdiz.deliveryservice.dto.request.GetDeliveryStatusRequestDto;
import com.lotdiz.deliveryservice.dto.response.DeliveryStatusResponseDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryResponseDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryStatusResponseDto;
import com.lotdiz.deliveryservice.service.DeliveryService;
import com.lotdiz.deliveryservice.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FundingClientController {

  private final DeliveryService deliveryService;

  @GetMapping(value = "/fundings/{fundingId}/delivery")
  public ResponseEntity<SuccessResponse<Map<String, GetDeliveryResponseDto>>> getDeliveryDetail(
      @PathVariable("fundingId") Long fundingId) {
    GetDeliveryResponseDto getDeliveryResponseDto = deliveryService.getDelivery(fundingId);
    return ResponseEntity.ok()
        .body(
            SuccessResponse.<Map<String, GetDeliveryResponseDto>>builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .detail("배송 조회 성공")
                .data(Map.of("delivery", getDeliveryResponseDto))
                .build());
  }

  @PostMapping("/delivery/status")
  public ResponseEntity<SuccessResponse<DeliveryStatusResponseDto>> getDeliveryStatus(
      @RequestBody List<Long> fundingId) {
    return ResponseEntity.ok()
        .body(
            SuccessResponse.<DeliveryStatusResponseDto>builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .data(deliveryService.getDeliveryStatus(fundingId))
                .build());
  }

  @PostMapping("/delivery/get-status")
  public ResponseEntity<SuccessResponse<Map<String, List<GetDeliveryStatusResponseDto>>>>
      getDeliveryStatusByFundingIds(
          @RequestBody GetDeliveryStatusRequestDto getDeliveryStatusRequestDto) {
    List<GetDeliveryStatusResponseDto> getDeliveryStatusResponseDtos =
        deliveryService.getDeliveryStatusByFundingIds(getDeliveryStatusRequestDto.getFundingIds());
    return ResponseEntity.ok()
        .body(
            SuccessResponse.<Map<String, List<GetDeliveryStatusResponseDto>>>builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .detail("배송 상태 조회 성공")
                .data(Map.of("fundings", getDeliveryStatusResponseDtos))
                .build());
  }
}
