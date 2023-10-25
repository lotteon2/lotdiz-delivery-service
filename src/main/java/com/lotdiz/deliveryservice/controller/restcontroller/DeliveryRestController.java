package com.lotdiz.deliveryservice.controller.restcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lotdiz.deliveryservice.dto.request.InformationForDeliveryStartNotificationRequestDto;
import com.lotdiz.deliveryservice.dto.response.DeliveryStartSuccessResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import com.lotdiz.deliveryservice.entity.DeliveryStatus;
import com.lotdiz.deliveryservice.exception.DeliveryStartException;
import com.lotdiz.deliveryservice.messagequeue.SendDeliveryRequestMessage;
import com.lotdiz.deliveryservice.service.DeliveryService;
import com.lotdiz.deliveryservice.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DeliveryRestController {

  private final DeliveryService deliveryService;
  private final SendDeliveryRequestMessage sendDeliveryRequestMessage;

  @PostMapping("/fundings/delivery-start-notification")
  public ResponseEntity<SuccessResponse<DeliveryStartSuccessResponseDto>>
      requestDeliveryStartNotification(
          @RequestBody
              InformationForDeliveryStartNotificationRequestDto
                  informationForDeliveryStartNotificationRequestDto)
          throws JsonProcessingException {
    // 배송 상태 업데이트
    Delivery delivery =
        deliveryService.modifyDeliveryStatus(informationForDeliveryStartNotificationRequestDto);
    if (delivery.getDeliveryStatus().equals(DeliveryStatus.PROCESSING)) {
      // 알림 시작 이벤트 발행
      sendDeliveryRequestMessage.sendDeliveryStartNotification(
          informationForDeliveryStartNotificationRequestDto);

      return ResponseEntity.ok()
          .body(
              SuccessResponse.<DeliveryStartSuccessResponseDto>builder()
                  .code(String.valueOf(HttpStatus.OK.value()))
                  .detail("배송 상태 변경")
                  .data(
                      DeliveryStartSuccessResponseDto.builder()
                          .deliveryStatusToProcessing("배송이 시작되었습니다!")
                          .build())
                  .message(HttpStatus.OK.name())
                  .build());
    } else {
      throw new DeliveryStartException();
    }
  }
}
