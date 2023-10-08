package com.lotdiz.deliveryservice.messagequeue;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotdiz.deliveryservice.dto.request.InformationForDeliveryStartNotificationRequestDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendDeliveryRequestMessage {

    private final AmazonSQS sqs;
    private final ObjectMapper objectMapper;
    @Value("${cloud.aws.sqs.delivery-start-notification-queue.url}")
    private String url;

    public SendMessageResult sendDeliveryStartNotification(
            InformationForDeliveryStartNotificationRequestDto informationForDeliveryStartNotificationRequestDto)
            throws JsonProcessingException {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(url,
                objectMapper.writeValueAsString(informationForDeliveryStartNotificationRequestDto))
                .withMessageGroupId("delivery-start-notification")
                .withMessageDeduplicationId(UUID.randomUUID().toString());
        return sqs.sendMessage(sendMessageRequest);
    }
}