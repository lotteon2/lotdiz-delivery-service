package com.lotdiz.deliveryservice.mapper;

import com.lotdiz.deliveryservice.dto.request.CreateDeliveryRequestDto;
import com.lotdiz.deliveryservice.dto.response.CreateDeliveryResponseDto;
import com.lotdiz.deliveryservice.entity.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {

  DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

  Delivery createDeliveryRequestDtoToDelivery(CreateDeliveryRequestDto createDeliveryRequestDto);

  @Mapping(source = "id", target = "deliveryId")
  CreateDeliveryResponseDto deliveryToCreateDeliveryResponseDto(Delivery delivery);
}
