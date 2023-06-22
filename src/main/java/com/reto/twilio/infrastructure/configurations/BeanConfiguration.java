package com.reto.twilio.infrastructure.configurations;

import com.reto.twilio.domain.api.ISmsNotificationSenderServicePort;
import com.reto.twilio.domain.spi.ITwilioSmsServiceProvider;
import com.reto.twilio.domain.usecase.SmsNotificationSenderUseCase;
import com.reto.twilio.infrastructure.drivenadapter.mapper.ITwilioMessageMapper;
import com.reto.twilio.infrastructure.drivenadapter.twilio.TwilioSmsAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITwilioMessageMapper twilioMessageMapper;

    @Bean
    public ITwilioSmsServiceProvider twilioSmsServiceProvider() {
        return new TwilioSmsAdapter(this.twilioMessageMapper);
    }

    @Bean
    public ISmsNotificationSenderServicePort smsNotificationSenderServicePort() {
        return new SmsNotificationSenderUseCase(twilioSmsServiceProvider());
    }
}
