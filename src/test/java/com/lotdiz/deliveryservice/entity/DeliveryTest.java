package com.lotdiz.deliveryservice.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DeliveryTest {

  @Autowired private EntityManager em;

  @Test
  void deliveryCreate() {
    // given
    Delivery delivery =
        Delivery.builder()
            .fundingId(1L)
            .deliveryTrackingNumber(1L)
            .deliveryRecipientName("테스트 수신자")
            .deliveryRecipientPhoneNumber("01011112222")
            .deliveryRecipientEmail("test@naver.com")
            .deliveryRoadName("테스트 도로명 주소")
            .deliveryAddressDetail("테스트 상세 주소")
            .deliveryZipCode("13333")
            .deliveryRequest("테스트 배송시 요청사항")
            .deliveryCost(3000L)
            .deliveryStatus(DeliveryStatus.PROCESSING)
            .build();

    // when
    em.persist(delivery);
    em.flush();
    em.clear();

    // then
    Delivery findDelivery = em.find(Delivery.class, 1L);
    Assertions.assertThat(findDelivery.getId()).isSameAs(delivery.getId());
  }
}
