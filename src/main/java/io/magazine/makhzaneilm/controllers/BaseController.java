package io.magazine.makhzaneilm.controllers;

import io.magazine.makhzaneilm.dto.RestResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * Creates a ResponseEntity to be sent back to client
     * @param restResponseDto holding the response object and HTTP status
     * @return ResponseEntity with HTTP status and response object
     */
    public static <T> ResponseEntity<RestResponseDto<T>> response(RestResponseDto<T> restResponseDto) {
        return new ResponseEntity<>(restResponseDto, restResponseDto.getStatus());
    }
}
