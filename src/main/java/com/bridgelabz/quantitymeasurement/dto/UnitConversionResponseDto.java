package com.bridgelabz.quantitymeasurement.dto;

public class UnitConversionResponseDto {

    private int statusCode;
    private String message;
    private Object responseData;

    public UnitConversionResponseDto(int statusCode, String message, Object responseData) {
        this.statusCode = statusCode;
        this.message = message;
        this.responseData = responseData;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getResponseData() {
        return responseData;
    }
}
