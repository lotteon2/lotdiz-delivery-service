package com.lotdiz.deliveryservice.mapper;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.response.GetDeliveryDetailResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {

    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deliveryTrackingNumber", ignore = true)
    @Mapping(target = "deliveryStatus", ignore = true)
    Delivery createDeliveryRequestDtoToDelivery(CreateDeliveryRequestDto createDeliveryRequestDto);

    @Mapping(source = "id", target = "deliveryId")
    GetDeliveryDetailResponseDto deliveryToGetDeliveryDetailResponseDto(Delivery delivery);
}
