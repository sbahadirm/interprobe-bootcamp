package com.bahadirmemis.interprobe.interprobebootcamp.generic.util;

import com.bahadirmemis.interprobe.interprobebootcamp.generic.enums.GeneralErrorMessage;
import com.bahadirmemis.interprobe.interprobebootcamp.generic.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
class MathUtilTest {

    @Test
    void shouldSum() {

        BigDecimal number1 = BigDecimal.valueOf(2);
        BigDecimal number2 = BigDecimal.valueOf(2);

        BigDecimal result = MathUtil.sum(number1, number2);

        Assertions.assertEquals(BigDecimal.valueOf(4), result);
    }

    @Test
    void shouldNotSumWhenNumber1IsNull() {

        BigDecimal number1 = null;
        BigDecimal number2 = BigDecimal.valueOf(2);

        BusinessException businessException = assertThrows(BusinessException.class, () -> MathUtil.sum(number1, number2));

        assertEquals(GeneralErrorMessage.VALUES_CANNOT_BE_NULL, businessException.getBaseErrorMessage());
    }

    @Test
    void shouldNotSumWhenNumber2IsNull() {

        BigDecimal number1= BigDecimal.valueOf(2);
        BigDecimal number2 = null;

        BusinessException businessException = assertThrows(BusinessException.class, () -> MathUtil.sum(number1, number2));

        assertEquals(GeneralErrorMessage.VALUES_CANNOT_BE_NULL, businessException.getBaseErrorMessage());
    }

    @Test
    void shouldSumWhenValuesAreZero() {

        BigDecimal number1 = BigDecimal.ZERO;
        BigDecimal number2 = BigDecimal.ZERO;

        BigDecimal result = MathUtil.sum(number1, number2);

        Assertions.assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void shouldSumWhenValuesAreNegative() {

        BigDecimal number1 = BigDecimal.valueOf(-3);
        BigDecimal number2 = BigDecimal.valueOf(-5);

        BigDecimal result = MathUtil.sum(number1, number2);

        Assertions.assertEquals(BigDecimal.valueOf(-8), result);
    }

    @Test
    void shouldSumWhenValuesHaveDecimalDigit() {

        BigDecimal number1 = BigDecimal.valueOf(3.99);
        BigDecimal number2 = BigDecimal.valueOf(5.11);

        BigDecimal result = MathUtil.sum(number1, number2);

        Assertions.assertEquals(new BigDecimal("9.10"), result);
    }
}