package com.bahadirmemis.interprobe.interprobebootcamp.generic.enums;

import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.BaseErrorMessage;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public enum GeneralErrorMessage implements BaseErrorMessage {

    VALUES_CANNOT_BE_NULL("Values cannot be null!"),
    ;

    private String message;

    GeneralErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
