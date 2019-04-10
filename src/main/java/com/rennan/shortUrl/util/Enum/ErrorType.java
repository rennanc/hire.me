package com.rennan.shortUrl.util.Enum;

public enum ErrorType {

    UNKNOW("000","UNKNOW ERROR"),
    ERROR_1("001","CUSTOM ALIAS ALREADY EXISTS"),
    ERROR_2("002","SHORTENED URL NOT FOUND");

    private String code;
    private String description;

    ErrorType(String code, String description){
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
