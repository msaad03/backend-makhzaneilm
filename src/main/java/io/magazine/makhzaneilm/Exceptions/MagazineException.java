package io.magazine.makhzaneilm.Exceptions;

import io.magazine.makhzaneilm.dto.ErrorDto;
import io.magazine.makhzaneilm.constants.enums.Error;

public class MagazineException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private String code;
        private String message;
        private String clientMessage;
        private Error error;
        private ErrorDto errorDto;

        protected MagazineException() {
            super();
        }

        public MagazineException(Error error) {
            super(error.getMessage());
            this.error = error;
            this.code = error.getCode();
            this.message = error.getMessage();
            this.clientMessage = error.getMessage();
        }

        public MagazineException(Error error, Throwable t) {
            super(error.getMessage(), t);
            this.error = error;
            this.code = error.getCode();
            this.message = error.getMessage();
            this.clientMessage = error.getMessage();
        }


        public MagazineException(ErrorDto errorDto) {
            super(errorDto.getErrorMessage());
            this.errorDto = errorDto;
            this.code = errorDto.getErrorCode();
            this.message = errorDto.getErrorMessage();
            this.clientMessage = errorDto.getErrorDetails();
        }

        public MagazineException(String message, String code, Exception e) {
            super(message, e);
            this.code = code;
            this.message = message;
            this.clientMessage = message;
        }

        public MagazineException(String message, String code) {
            super(message);
            this.code = code;
            this.message = message;
            this.clientMessage = message;
        }

        public String getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }

        public String getClientMessage() {
            return clientMessage;
        }

        public Error getError () {
            return error;
        }

        public ErrorDto getErrorDto () {
            return errorDto;
        }

    }
