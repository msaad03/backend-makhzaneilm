package io.magazine.makhzaneilm.exceptions;

import io.magazine.makhzaneilm.dto.ErrorDto;
import io.magazine.makhzaneilm.constants.enums.Error;

public class EntityNotFoundException extends MagazineException {

    protected EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(Error error) {
        super(error);
    }

    public EntityNotFoundException(ErrorDto errorDto) {
        super(errorDto);
    }

    public EntityNotFoundException(Error message, Throwable code) {super(message, code); }
}
