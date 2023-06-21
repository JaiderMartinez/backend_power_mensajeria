package com.reto.twilio.application.handler.implementation;

import com.reto.twilio.application.dto.request.OrderNotificationRequestDto;
import com.reto.twilio.application.dto.response.OrderNotifiedResponseDto;
import com.reto.twilio.application.handler.IEmployeeService;
import com.reto.twilio.application.mapper.requestmapper.IEmployeeRequestMapper;
import com.reto.twilio.application.mapper.responsemapper.IEmployeeResponseMapper;
import com.reto.twilio.domain.api.ISmsNotificationSenderServicePort;
import com.reto.twilio.domain.model.SmsMessageBuilder;
import com.reto.twilio.domain.model.TwilioMessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final ISmsNotificationSenderServicePort smsNotificationSenderServicePort;
    private final IEmployeeRequestMapper employeeRequestMapper;
    private final IEmployeeResponseMapper employeeResponseMapper;

    @Override
    public OrderNotifiedResponseDto notifyThatOrderIsReady(OrderNotificationRequestDto orderNotificationRequest) {
        final SmsMessageBuilder smsMessageBuilderToSendRequest = this.employeeRequestMapper.orderNotificationRequestDtoToSmsMessageBuilder(orderNotificationRequest);
        final TwilioMessageModel messageModelSent = this.smsNotificationSenderServicePort.sendMessageNotificationToCustomer(smsMessageBuilderToSendRequest);
        return this.employeeResponseMapper.twilioMessageModelToOrderNotifiedResponseDto(messageModelSent);
    }
}
