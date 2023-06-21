package com.reto.twilio.domain.api;

import com.reto.twilio.domain.model.SmsMessageBuilder;
import com.reto.twilio.domain.model.TwilioMessageModel;

public interface ISmsNotificationSenderServicePort {

    TwilioMessageModel sendMessageNotificationToCustomer(SmsMessageBuilder smsMessageBuilder);
}
