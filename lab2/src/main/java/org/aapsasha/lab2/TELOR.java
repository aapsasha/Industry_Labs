package org.aapsasha.lab2;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class TELOR {
    public static BigDecimal TEL(BigDecimal x, BigDecimal k){
        BigDecimal epsilon = BigDecimal.valueOf(Math.pow(10,-k.doubleValue()- 5));
        BigDecimal sum = new BigDecimal(0);
        BigDecimal tmp = x;
        BigDecimal i = BigDecimal.valueOf(3);
        while(tmp.abs().compareTo(epsilon) == 1){
            sum = sum.add(tmp);
            tmp = tmp.divide(i,k.intValue()+1, RoundingMode.HALF_UP);
            tmp = tmp.divide(i.subtract(BigDecimal.valueOf(1)),k.intValue()+1, RoundingMode.HALF_UP);

            tmp = tmp.multiply(BigDecimal.valueOf(Math.pow(x.doubleValue(),2)));
             i =i.add(BigDecimal.valueOf(2));
        }
        return sum;
    }
}
