package com.reto.twilio.domain.usecase;

import com.reto.twilio.domain.model.SmsMessageBuilder;
import com.reto.twilio.domain.model.TwilioMessageModel;
import com.reto.twilio.domain.spi.ITwilioSmsServiceProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SmsNotificationSenderUseCaseTest {

    @InjectMocks
    private SmsNotificationSenderUseCase smsNotificationSenderUseCase;
    @Mock
    private ITwilioSmsServiceProvider twilioSmsServiceProvider;

    @Test
    void test_sendMessageNotificationToCustomer_withRequestFromObjectAsSmsMessageBuilderCorrect_shouldReturnObjectAsTwilioMessageModelWithFieldsStatusEqualsDelivered() {
        //Given
        String bodyMessageExpected = "Sent from your Twilio trial account - Estimado cliente Roberto su pedido del restaurante Tacos picantes con el pin 12345 esta listo para ser recogido";
        String bodyMessageRequest = " Estimado cliente Roberto su pedido del restaurante Tacos picantes con el pin 12345 esta listo para ser recogido";
        SmsMessageBuilder smsMessageBuilder = new SmsMessageBuilder(12345L, "Tacos picantes", "Roberto", "3982391327");
        TwilioMessageModel twilioMessageModelExpected = new TwilioMessageModel(null, "+573982391327", bodyMessageExpected, null, null,
                "Delivered", "Outgoing_API", LocalDate.now(), LocalDate.now());
        when(this.twilioSmsServiceProvider.sendNotification(argThat(twilioMessageRequest -> twilioMessageRequest.getCellPhone().equals("+573982391327") &&
                twilioMessageRequest.getBodyMessage().equals(bodyMessageRequest)
        ))).thenReturn(twilioMessageModelExpected);
        //When
        TwilioMessageModel twilioMessageModelResult = this.smsNotificationSenderUseCase.sendMessageNotificationToCustomer(smsMessageBuilder);
        //Then
        assertEquals(twilioMessageModelExpected.getBodyMessage(), twilioMessageModelResult.getBodyMessage());
        assertEquals(twilioMessageModelExpected.getCellPhone(), twilioMessageModelResult.getCellPhone());
        assertEquals(twilioMessageModelExpected.getStatus(), twilioMessageModelResult.getStatus());
        assertEquals(twilioMessageModelExpected.getDirection(), twilioMessageModelResult.getDirection());
        assertEquals(twilioMessageModelExpected.getDateCreated(), twilioMessageModelResult.getDateCreated());
        assertEquals(twilioMessageModelExpected.getDateUpdated(), twilioMessageModelResult.getDateUpdated());
    }
}