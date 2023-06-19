package com.reto.twilio.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderNotifiedResponseDto {

    private String status;
    private String errorCode;
    private String errorMessage;
}
