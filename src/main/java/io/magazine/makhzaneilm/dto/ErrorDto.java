package io.magazine.makhzaneilm.dto;

import io.magazine.makhzaneilm.constants.enums.Error;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorDto {

    private String errorCode;

    private String errorMessage;

    private String errorDetails;

    private List<ErrorDto> childErrors = new ArrayList<>();

    public ErrorDto(Errors errors) {
        this.errorCode =  Integer.toString(HttpStatus.BAD_REQUEST.value());
        this.errorMessage = errors.getFieldError().getDefaultMessage();
        this.errorDetails = this.errorMessage;
    }

    public ErrorDto(String errorCode, String errorMessage, String errorDetails) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }

    public ErrorDto(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorDto(Error error) {
        this.errorCode = error.getCode();
        this.errorMessage = error.getMessage();
    }

    public ErrorDto(Error error, String errorDetails) {
        this.errorCode = error.getCode();
        this.errorMessage = error.getMessage();
        this.errorDetails = errorDetails;
    }

    public void addChildError(ErrorDto errorDto) {

        childErrors.add(errorDto);
    }

    @Override
    public String toString() {
        return "ErrorDto [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorDetails=" + errorDetails + ", childErrors=" + childErrors + "]";
    }

}


