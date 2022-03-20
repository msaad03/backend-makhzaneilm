package io.magazine.makhzaneilm.Exceptions;

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

    public EntityNotFoundException(String message, String code) {super(message, code); }
}
