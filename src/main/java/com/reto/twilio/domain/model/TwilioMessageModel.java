package com.reto.twilio.domain.model;

import java.time.LocalDate;

public class TwilioMessageModel {

    private String uniqueMessageIdentifier;
    private String cellPhone;
    private String bodyMessage;
    private String errorCode;
    private String errorMessage;
    private String status;
    private String direction;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;

    public TwilioMessageModel() {
    }

    public TwilioMessageModel(String cellPhone, String bodyMessage) {
        this.cellPhone = cellPhone;
        this.bodyMessage = bodyMessage;
    }

    public TwilioMessageModel(String uniqueMessageIdentifier, String cellPhone, String bodyMessage, String errorCode,
                              String errorMessage, String status, String direction, LocalDate dateCreated, LocalDate dateUpdated) {
        this.uniqueMessageIdentifier = uniqueMessageIdentifier;
        this.cellPhone = cellPhone;
        this.bodyMessage = bodyMessage;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
        this.direction = direction;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
