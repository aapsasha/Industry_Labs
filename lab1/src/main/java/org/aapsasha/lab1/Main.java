package org.aapsasha.lab1;

import java.io.*;
import java.math.BigDecimal;
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
            BigDecimal answer2 = answer1.setScale(k.intValue() + 1, BigDecimal.ROUND_CEILING);
            System.out.print("мой ответ: ");
            System.out.println(answer2);
            System.out.print("предпологаемый ответ: ");
            System.out.print(Math.sinh(x.doubleValue()));
        }

    }
