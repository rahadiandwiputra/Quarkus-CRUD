package org.acme.commandmode.utils;

import org.acme.commandmode.DTO.ResponseDTO;

public class ResponseUtils {
    public static void setResponse(ResponseDTO response, ResponseEnum responseEnum) {
        response.setStatus(responseEnum.getStatus());
        response.setStatusCode(responseEnum.getCode());
    }
}
