package com.desafio.infracoes.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleHttpMessageNotReadableException(
            HttpServletRequest req, HttpMessageNotReadableException ex) {
        logger.error(ex.getMessage(), ex);
        return parseError(req, ex);
    }

    private Map<String, Object> parseError(HttpServletRequest req, Exception exception) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("message_developer", exception.getClass().toString());
        objectMap.put("message_user", exception.getMessage());
        objectMap.put("uri", req.getRequestURI());
        return objectMap;
    }

}
