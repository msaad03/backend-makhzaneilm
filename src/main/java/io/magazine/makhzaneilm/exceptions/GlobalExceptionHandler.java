package io.magazine.makhzaneilm.exceptions;

import io.magazine.makhzaneilm.controllers.BaseController;
import io.magazine.makhzaneilm.dto.RestResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { MagazineException.class })
    public ResponseEntity<RestResponseDto<Void>> magazineException(MagazineException ex) {
        final var restResponseDto = new RestResponseDto<Void>();
        restResponseDto.makeFailureResponse(ex.getError(), HttpStatus.BAD_REQUEST);

        return BaseController.response(restResponseDto);
    }
}
