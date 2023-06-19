package com.reto.twilio.domain.usecase;

import com.reto.twilio.domain.api.ISmsNotificationSenderServicePort;
import com.reto.twilio.domain.model.TwilioMessageModel;
import com.reto.twilio.domain.spi.ITwilioSmsServiceProvider;

public class SmsNotificationSenderUseCase implements ISmsNotificationSenderServicePort {

    private final ITwilioSmsServiceProvider twilioSmsServiceProvider;

    public SmsNotificationSenderUseCase(ITwilioSmsServiceProvider twilioSmsServiceProvider) {
        this.twilioSmsServiceProvider = twilioSmsServiceProvider;
    }

    @Override
    public TwilioMessageModel sendMessageNotificationToCustomer(String cellPhone, String restaurantName, String customerName, Long orderPin) {
        if (!cellPhone.startsWith("+")) {
            cellPhone  = "+57" + cellPhone;
        }
        TwilioMessageModel requestToSendCellPhoneAMessageToCustomer = new TwilioMessageModel();
        requestToSendCellPhoneAMessageToCustomer.setCellPhone(cellPhone);
        String messageBodyToSend = "!Hola " + customerName + " tu pedido del restaurante" + restaurantName + " con el pin " + orderPin + " se encuentra listo, por favor acercase a caja";
        requestToSendCellPhoneAMessageToCustomer.setBodyMessage(messageBodyToSend);
        return this.twilioSmsServiceProvider.sendNotification(requestToSendCellPhoneAMessageToCustomer);
    }
}
