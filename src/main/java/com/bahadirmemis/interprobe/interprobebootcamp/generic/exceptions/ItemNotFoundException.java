package com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException{

    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
