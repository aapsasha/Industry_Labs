package org.aapsasha.lab3;

import java.text.NumberFormat;
import java.util.Random;

public class MatrixBuilder {
    public static Integer[][] build(int vertical_size,int horizontal_size){
        Integer[][] mas = new Integer[vertical_size][horizontal_size+1];
        System.out.println ("new matrix: ");
        Random r = new Random(System.currentTimeMillis());
        NumberFormat format1 = NumberFormat.getInstance();
        format1.setMinimumIntegerDigits(3);
        for(int i = 0; i < vertical_size;i++){
            mas[i][horizontal_size] = 0;
            for(int j =0 ;j < horizontal_size;j++){
                mas[i][j] = r.nextInt(200) - 100;
                if(j%2 == 1){
                    mas[i][horizontal_size] += Math.max(mas[i][j], 0);
                }
            }
        }
        return mas;
    }
}
