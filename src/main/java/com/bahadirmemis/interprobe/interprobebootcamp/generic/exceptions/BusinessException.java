package com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{

    private final BaseErrorMessage baseErrorMessage;
}
