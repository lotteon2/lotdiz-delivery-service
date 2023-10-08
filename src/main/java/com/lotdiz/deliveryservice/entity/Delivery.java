package com.lotdiz.deliveryservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "funding_id", unique = true, nullable = false)
    private Long fundingId;

    @Column(name = "delivery_tracking_number")
    private Long deliveryTrackingNumber;

    @Column(name = "delivery_recipient_name", nullable = false)
    private String deliveryRecipientName;

    @Column(name = "delivery_recipient_phone_number", nullable = false)
    private String deliveryRecipientPhoneNumber;

    @Column(name = "delivery_recipient_email")
    @Check(constraints = "delivery_recipient_email LIKE '%@%'")
    private String deliveryRecipientEmail;

    @Column(name = "delivery_road_name", nullable = false)
    private String deliveryRoadName;

    @Column(name = "delivery_address_detail", nullable = false)
    private String deliveryAddressDetail;

    @Column(name = "delivery_zip_code", nullable = false)
    private String deliveryZipCode;

    @Column(name = "delivery_request")
    private String deliveryRequest;

    @Column(name = "delivery_cost", nullable = false)
    private Long deliveryCost;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(
            name = "delivery_status",
            nullable = false,
            columnDefinition = "VARCHAR(255) DEFAULT 'PENDING'")
    private DeliveryStatus deliveryStatus = DeliveryStatus.PENDING;

    public void setFundingId(Long fundingId) {
        this.fundingId = fundingId;
    }

    public Delivery modifyDeliveryStatusToProcessing() {
        this.deliveryStatus = DeliveryStatus.PROCESSING;
        return this;
    }
}
