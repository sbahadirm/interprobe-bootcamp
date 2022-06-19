package com.bahadirmemis.interprobe.interprobebootcamp.springcore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Component
//@Primary
@Qualifier("xml")
public class ResponseConverterXml implements ResponseConverter {
    @Override
    public void convert() {
        System.out.println("XML");
    }
}
