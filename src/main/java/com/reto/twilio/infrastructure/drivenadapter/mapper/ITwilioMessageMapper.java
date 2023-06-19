package com.reto.twilio.infrastructure.drivenadapter.mapper;

import com.reto.twilio.domain.model.TwilioMessageModel;
import com.twilio.rest.api.v2010.account.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ITwilioMessageMapper {

    @Mapping(target = "uniqueMessageIdentifier", source = "sid")
    @Mapping(target = "cellPhone", source = "to")
    @Mapping(target = "bodyMessage", source = "body")
    @Mapping(target = "priceMessage", source = "price")
    TwilioMessageModel messageToTwilioMessageModel(Message message);
}
