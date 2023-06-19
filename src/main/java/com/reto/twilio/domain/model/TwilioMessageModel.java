package com.reto.twilio.domain.model;

public class TwilioMessageModel {

    private String uniqueMessageIdentifier;
    private String cellPhone;
    private String bodyMessage;
    private String errorCode;
    private String errorMessage;
    private String status;
    private String priceMessage;

    public TwilioMessageModel() {
    }

    public TwilioMessageModel(String uniqueMessageIdentifier, String cellPhone, String bodyMessage, String errorCode, String errorMessage,
                              String status, String priceMessage) {
        this.uniqueMessageIdentifier = uniqueMessageIdentifier;
        this.cellPhone = cellPhone;
        this.bodyMessage = bodyMessage;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
        this.priceMessage = priceMessage;
    }

    public String getUniqueMessageIdentifier() {
        return uniqueMessageIdentifier;
    }

    public void setUniqueMessageIdentifier(String uniqueMessageIdentifier) {
        this.uniqueMessageIdentifier = uniqueMessageIdentifier;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getBodyMessage() {
        return bodyMessage;
    }

    public void setBodyMessage(String bodyMessage) {
        this.bodyMessage = bodyMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriceMessage() {
        return priceMessage;
    }

    public void setPriceMessage(String priceMessage) {
        this.priceMessage = priceMessage;
    }
}
