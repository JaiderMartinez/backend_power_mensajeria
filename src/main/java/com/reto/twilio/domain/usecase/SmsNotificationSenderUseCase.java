package com.reto.twilio.domain.usecase;

import com.reto.twilio.domain.api.ISmsNotificationSenderServicePort;
import com.reto.twilio.domain.model.SmsMessageBuilder;
import com.reto.twilio.domain.model.TwilioMessageModel;
import com.reto.twilio.domain.spi.ITwilioSmsServiceProvider;

public class SmsNotificationSenderUseCase implements ISmsNotificationSenderServicePort {

    private final ITwilioSmsServiceProvider twilioSmsServiceProvider;

    public SmsNotificationSenderUseCase(ITwilioSmsServiceProvider twilioSmsServiceProvider) {
        this.twilioSmsServiceProvider = twilioSmsServiceProvider;
    }

    @Override
    public TwilioMessageModel sendMessageNotificationToCustomer(SmsMessageBuilder smsMessageBuilder) {
        if (!smsMessageBuilder.getCustomerCellPhone().startsWith("+")) {
            smsMessageBuilder.setCustomerCellPhone("+57" + smsMessageBuilder.getCustomerCellPhone());
        }
        TwilioMessageModel messageToSentToTheCustomerCellPhone = new TwilioMessageModel();
        messageToSentToTheCustomerCellPhone.setCellPhone(smsMessageBuilder.getCustomerCellPhone());
        messageToSentToTheCustomerCellPhone.setBodyMessage(smsMessageBuilder.generateMessage());
        return this.twilioSmsServiceProvider.sendNotification(messageToSentToTheCustomerCellPhone);
    }
}
