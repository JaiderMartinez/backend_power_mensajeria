package com.reto.twilio.infrastructure.drivenadapter.twilio;

import com.reto.twilio.domain.model.TwilioMessageModel;
import com.reto.twilio.domain.spi.ITwilioSmsServiceProvider;
import com.reto.twilio.infrastructure.drivenadapter.mapper.ITwilioMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RequiredArgsConstructor
public class TwilioSmsAdapter implements ITwilioSmsServiceProvider {

    private final ITwilioMessageMapper twilioMessageMapper;

    @Value("${twilio.account.sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth.token}")
    private String twilioAuthToken;

    @Value("${twilio.phone.from}")
    private String numberPhoneOfTwilioFrom;

    @Override
    public TwilioMessageModel sendNotification(TwilioMessageModel twilioMessageModelRequest) {
        Twilio.init(this.twilioAccountSid, this.twilioAuthToken);
        Message messageResponse = Message.creator(
                        new PhoneNumber(twilioMessageModelRequest.getCellPhone()),
                        new PhoneNumber(this.numberPhoneOfTwilioFrom),
                        twilioMessageModelRequest.getBodyMessage())
                .create();
        return this.twilioMessageMapper.messageToTwilioMessageModel(messageResponse);
    }
}
