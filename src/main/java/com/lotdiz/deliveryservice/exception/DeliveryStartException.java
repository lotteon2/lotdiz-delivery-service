package com.lotdiz.deliveryservice.exception;

import com.lotdiz.deliveryservice.exception.common.DomainException;
import javax.servlet.http.HttpServletResponse;

public class DeliveryStartException extends DomainException {
  private static final String message = "배송에 실패 했습니다.";

  public DeliveryStartException() {
    super(message);
  }

  @Override
  public int getStatusCode() {
    return HttpServletResponse.SC_BAD_REQUEST;
  }
}
