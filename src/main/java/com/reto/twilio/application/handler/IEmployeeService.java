package com.reto.twilio.application.handler;

import com.reto.twilio.application.dto.request.OrderNotificationRequestDto;
import com.reto.twilio.application.dto.response.OrderNotifiedResponseDto;

public interface IEmployeeService {

    OrderNotifiedResponseDto notifyThatOrderIsReady(OrderNotificationRequestDto orderNotificationRequestDto);
}
