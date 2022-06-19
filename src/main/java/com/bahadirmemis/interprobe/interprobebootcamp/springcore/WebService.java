package com.bahadirmemis.interprobe.interprobebootcamp.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
public class WebService {

    private ResponseConverter responseConverter;

    public WebService(@Qualifier("json") ResponseConverter responseConverter) {
        this.responseConverter = responseConverter;
    }

    public void convertResponse(){
        responseConverter.convert();
    }
}
