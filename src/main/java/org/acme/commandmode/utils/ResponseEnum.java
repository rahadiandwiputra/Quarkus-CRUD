package org.acme.commandmode.utils;

public enum ResponseEnum {
    SUCCESS("Success", 200),
    INTERNAL_SERVER_ERROR("Internal Server Error", 500);

    private String status;
    private int code;

    ResponseEnum(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }


    public int getCode() {
        return code;
    }
}
