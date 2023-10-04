CREATE TABLE Delivery
(
    delivery_id                     BIGINT AUTO_INCREMENT PRIMARY KEY,
    funding_id                      BIGINT                         NOT NULL UNIQUE,
    delivery_tracking_number        BIGINT,
    delivery_recipient_name         VARCHAR(255)                   NOT NULL,
    delivery_recipient_phone_number VARCHAR(255)                   NOT NULL,
    delivery_recipient_email        VARCHAR(255) CHECK (delivery_recipient_email LIKE '%@%'),
    delivery_road_name              VARCHAR(255)                   NOT NULL,
    delivery_address_detail         VARCHAR(255)                   NOT NULL,
    delivery_zip_code               VARCHAR(255)                   NOT NULL,
    delivery_request                VARCHAR(255),
    delivery_cost                   BIGINT                         NOT NULL,
    delivery_status                 VARCHAR(255) DEFAULT 'PENDING' NOT NULL
);
