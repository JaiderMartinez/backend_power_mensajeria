package com.reto.twilio.domain.api;

import com.reto.twilio.domain.model.TwilioMessageModel;

public interface ISmsNotificationSenderServicePort {

    TwilioMessageModel sendMessageNotificationToCustomer(String cellPhone, String restaurantName, String customerName, Long pin);
}
