package com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions;

import com.bahadirmemis.interprobe.interprobebootcamp.generic.response.RestErrorResponse;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        // ResponseEntity -> RestResponse -> RestErrorResponse

        Date errorDate = new Date();
        String message = ex.getMessage();
        String detail = webRequest.getDescription(false);

        RestErrorResponse restErrorResponse = new RestErrorResponse(errorDate, message, detail);

        RestResponse<RestErrorResponse> restResponse = RestResponse.error(restErrorResponse);

        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
