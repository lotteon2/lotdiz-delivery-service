package com.lotdiz.deliveryservice.controller.restcontroller;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lotdiz.deliveryservice.messagequeue.SendDeliveryRequestMessage;
import com.lotdiz.deliveryservice.service.DeliveryService;
import com.lotdiz.deliveryservice.utils.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryRestController {

    private final DeliveryService deliveryService;
    private final SendDeliveryRequestMessage sendDeliveryRequestMessage;

    @GetMapping("fundings/{fundingId}/delivery-start-notification")
    public ResponseEntity<SuccessResponse> requestDeliveryStartNotification(
            @PathVariable Long fundingId) throws JsonProcessingException {
        // 배송 상태 업데이트
//        Long modifiedDeliveryStatusId = deliveryService.modifyDeliveryStatus(fundingId);
        // 알림 시작 이벤트 발행
        SendMessageResult sendMessageResult = sendDeliveryRequestMessage.sendDeliveryStartNotification(
                fundingId);

        return ResponseEntity.ok()
                .body(SuccessResponse.builder().code(String.valueOf(HttpStatus.OK.value()))
                        .detail("배송 상태 변경").data(sendMessageResult).message(HttpStatus.OK.name())
                        .build());
    }
}
