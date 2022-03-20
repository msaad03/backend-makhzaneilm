package io.magazine.makhzaneilm.constants.enums;

public enum Error {

    ENTITY_NOT_FOUND("M-001", "Entity not found");

    private final String code;
    private final String message;

    Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() { return message; }

}
