package com.reto.twilio.domain.model;

public class SmsMessageBuilder {

    private Long orderPin;
    private String restaurantName;
    private String customerName;
    private String customerCellPhone;

    public SmsMessageBuilder() {
    }

    public SmsMessageBuilder(Long orderPin, String restaurantName, String customerName, String customerCellPhone) {
        this.orderPin = orderPin;
        this.restaurantName = restaurantName;
        this.customerName = customerName;
        this.customerCellPhone = customerCellPhone;
    }

    public Long getOrderPin() {
        return orderPin;
    }

    public void setOrderPin(Long orderPin) {
        this.orderPin = orderPin;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCellPhone() {
        return customerCellPhone;
    }

    public void setCustomerCellPhone(String customerCellPhone) {
        this.customerCellPhone = customerCellPhone;
    }

    public String generateMessage() {
        return " :: Estimado cliente " + this.customerName + " su pedido con el pin " + this.orderPin + " esta listo para ser recogido en el restaurante " + this.restaurantName;
    }
}
