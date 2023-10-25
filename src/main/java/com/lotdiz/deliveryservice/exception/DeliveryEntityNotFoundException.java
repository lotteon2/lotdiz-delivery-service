package com.lotdiz.deliveryservice.exception;

import com.lotdiz.deliveryservice.exception.common.EntityNotFoundException;

public class DeliveryEntityNotFoundException extends EntityNotFoundException {

  private static final String message = "배송 정보를 찾을 수 없습니다.";

  public DeliveryEntityNotFoundException() {
    super(message);
  }
}
