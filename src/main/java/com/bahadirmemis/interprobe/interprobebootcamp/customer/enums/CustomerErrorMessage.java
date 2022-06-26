package com.bahadirmemis.interprobe.interprobebootcamp.customer.enums;

import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.BaseErrorMessage;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public enum CustomerErrorMessage implements BaseErrorMessage {

    CUSTOMER_DOES_NOT_EXIST("Customer does not exist!")
    ;

    private String message;

    CustomerErrorMessage(String message) {
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
