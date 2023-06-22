package com.reto.twilio.application.mapper.responsemapper;

import com.reto.twilio.application.dto.response.OrderNotifiedResponseDto;
import com.reto.twilio.domain.model.TwilioMessageModel;
import org.mapstruct.Mapper;

@Mapper
public interface IEmployeeResponseMapper {

    OrderNotifiedResponseDto twilioMessageModelToOrderNotifiedResponseDto(TwilioMessageModel twilioMessageModel);
}
