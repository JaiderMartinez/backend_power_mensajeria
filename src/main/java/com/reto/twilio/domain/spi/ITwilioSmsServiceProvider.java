package com.reto.twilio.domain.spi;

import com.reto.twilio.domain.model.TwilioMessageModel;

public interface ITwilioSmsServiceProvider {

    TwilioMessageModel sendNotification(TwilioMessageModel twilioMessageModel);
}
