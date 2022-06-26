package com.bahadirmemis.interprobe.interprobebootcamp.generic.util;

import com.bahadirmemis.interprobe.interprobebootcamp.generic.enums.GeneralErrorMessage;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.BusinessException;

import java.math.BigDecimal;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class MathUtil {

    public static BigDecimal sum(BigDecimal number1, BigDecimal number2){

//        if (number1 == null){
//            number1 = BigDecimal.ZERO;
//        }
//
//        if (number2 == null){
//            number2 = BigDecimal.ZERO;
//        }

        if (number1 == null || number2 == null){
            throw new BusinessException(GeneralErrorMessage.VALUES_CANNOT_BE_NULL);
        }

        return number1.add(number2);
    }
}
