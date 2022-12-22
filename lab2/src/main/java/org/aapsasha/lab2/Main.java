package org.aapsasha.lab2;

import java.io.IOException;
import java.math.BigDecimal;
   import java.util.Formatter;
   import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException
    {

        Scanner scanner = new Scanner(System.in);
        System.out.print ("Enter x: ");
        BigDecimal x = new BigDecimal(scanner.next());
        System.out.print ("Enter k: ");
        BigDecimal k = new BigDecimal(scanner.next());
        BigDecimal answer1 = new BigDecimal(String.valueOf(TELOR.TEL(x,k)));
        BigDecimal answer2 = answer1.setScale(k.intValue()+1,BigDecimal.ROUND_CEILING);
        Formatter fmt = new Formatter();

        fmt.format("входные данные:%nx: %1$+(10.4f%nk(hex): %2$#5x %nk(octal): %2$5o %nмой ответ: %3$010.10f%n%nпредпологаемый ответ: %4$,f",x.doubleValue(),k.intValue(),answer2.doubleValue(),Math.sinh(x.doubleValue()));
        System.out.print(fmt);
    }

}