package io.magazine.makhzaneilm.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.magazine.makhzaneilm.constants.enums.Error;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.Serializable;

@Data
public class RestResponseDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseDto.class);

    @JsonIgnore
    protected HttpStatus status = HttpStatus.OK; //HttpStatus.BAD_REQUEST

    public T data;

    protected ErrorDto error;

    protected boolean success;


    public RestResponseDto() {
        setSuccess(false);
    }


    public RestResponseDto<T> makeSuccessResponse(HttpStatus status) {
        setSuccess(true);
        setStatus(status);
        return this;
    }

    //TODO: directly return from all usages instead of creating new variables
    public RestResponseDto<T> makeSuccessResponse(T data) {
        this.makeSuccessResponse(data, HttpStatus.OK);
        return this;
    }

    public RestResponseDto<T> makeSuccessResponse(T data, HttpStatus status) {
        setSuccess(true);
        setStatus(status);
        setData(data);
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(ErrorDto errorDto) {
        this.makeFailureResponse(errorDto, HttpStatus.BAD_REQUEST); // HttpStatus.BAD_REQUEST
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(ErrorDto errorDto, HttpStatus status) {
        setError(errorDto);
        setStatus(status);
        setSuccess(Boolean.FALSE);
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(Error error, HttpStatus status) {
        makeFailureResponse(error, status, true);
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(Error error, HttpStatus status, boolean rollbackTransaction) {
        setError(new ErrorDto(error));
        setStatus(status);
        setSuccess(Boolean.FALSE);

        if (rollbackTransaction) {
            try {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } catch (NoTransactionException e) {
                // Ignore if no transaction was present
            } catch (Exception e) {
                LOGGER.error("Error while rolling back transaction", e);
            }
        }
        return this;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    private void setSuccess(boolean success) {
        this.success = success;
    }

    public static <T> RestResponseDto<T> success(T data) {
        return new RestResponseDto<T>().makeSuccessResponse(data);
    }
}

