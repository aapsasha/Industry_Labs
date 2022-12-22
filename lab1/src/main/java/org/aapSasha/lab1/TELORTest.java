package org.aapSasha.lab1;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class TELORTest {

    @Test
    @Name("first test 0")
    void TEL0() {
        BigDecimal myAnswer = TELOR.TEL(new BigDecimal(0),new BigDecimal(4));
        BigDecimal answer = new BigDecimal(Math.sinh(0));
        answer = answer.setScale(4, RoundingMode.DOWN);
        assertEquals(answer,myAnswer);
    }
    @Test
    @Name("first test 1")
    void TEL1() {
        BigDecimal myAnswer = TELOR.TEL(new BigDecimal(1),new BigDecimal(3));
        BigDecimal answer = new BigDecimal(Math.sinh(1));
        answer = answer.setScale(3, RoundingMode.DOWN);
        assertEquals(answer,myAnswer);
    }
    @Test
    @Name("first test 0.5")
    void TEL05() {
        BigDecimal myAnswer = TELOR.TEL(new BigDecimal(0.5),new BigDecimal(7));
        BigDecimal answer = new BigDecimal(Math.sinh(0.5));
        answer = answer.setScale(7, RoundingMode.DOWN);
        assertEquals(answer,myAnswer);
    }
}