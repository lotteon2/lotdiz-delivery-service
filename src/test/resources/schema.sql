CREATE TABLE delivery
(
    delivery_id                     BIGINT AUTO_INCREMENT NOT NULL,
    created_at                      datetime     NULL,
    updated_at                      datetime     NULL,
    funding_id                      BIGINT       NOT NULL,
    delivery_tracking_number        BIGINT       NULL,
    delivery_recipient_name         VARCHAR(255) NOT NULL,
    delivery_recipient_phone_number VARCHAR(255) NOT NULL,
    delivery_recipient_email        VARCHAR(255) NULL,
    delivery_road_name              VARCHAR(255) NOT NULL,
    delivery_address_detail         VARCHAR(255) NOT NULL,
    delivery_zip_code               VARCHAR(255) NOT NULL,
    delivery_request                VARCHAR(255) NULL,
    delivery_cost                   BIGINT       NOT NULL,
    delivery_status                 VARCHAR(255) NOT NULL,
    CONSTRAINT pk_delivery PRIMARY KEY (delivery_id)
);

ALTER TABLE delivery
    ADD CONSTRAINT uc_delivery_funding UNIQUE (funding_id);
