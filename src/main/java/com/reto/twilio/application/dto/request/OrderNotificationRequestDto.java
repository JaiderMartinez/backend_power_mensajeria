package com.reto.twilio.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderNotificationRequestDto {

    private Long orderPin;
    private String restaurantName;
    private String customerName;
    private String customerCellPhone;
}
