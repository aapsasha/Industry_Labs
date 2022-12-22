package org.aapsasha.lab3;

import java.text.NumberFormat;

public class Matrix {
    public static void show(Integer[][] matrix, NumberFormat format1){
        for (Integer[] integers : matrix) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                System.out.printf(" " + format1.format(integers[j]));
            }
            System.out.printf(" | %d%n", integers[matrix.length - 1]);
        }
    }

}
