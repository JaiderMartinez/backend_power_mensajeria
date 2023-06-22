package com.reto.twilio.application.mapper.requestmapper;

import com.reto.twilio.application.dto.request.OrderNotificationRequestDto;
import com.reto.twilio.domain.model.SmsMessageBuilder;
import org.mapstruct.Mapper;

@Mapper
public interface IEmployeeRequestMapper {

    SmsMessageBuilder orderNotificationRequestDtoToSmsMessageBuilder(OrderNotificationRequestDto orderNotificationRequestDto);
}
