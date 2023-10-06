package com.lotdiz.deliveryservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderConsumer {

  private final DeliveryService deliveryService;

  @KafkaListener(topics = "create-order")
  public void createDelivery(String message, Acknowledgment ack) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      CreateDeliveryRequestDto createDeliveryRequestDto =
          mapper.readValue(message, CreateDeliveryRequestDto.class);

      deliveryService.createDelivery(createDeliveryRequestDto);
      // 메시지 컨슘 후 메시지 삭제
      ack.acknowledge();
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
