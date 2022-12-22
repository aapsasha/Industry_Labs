package org.aapsasha.lab3;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

class basicComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        int j1 = (int)o1;
        int j2 = (int)o2;
        return (Integer.compare(j1, j2));
    }
}
class matrixComparator implements Comparator{
    public int compare(Object o1,Object o2){
        Integer[] string1 = (Integer[])o1;
        Integer[] string2 = (Integer[])o2;
        int size = string1.length-1;
        return (string1[size].compareTo(string2[size]));
    }

}
class mybinary{
    public static int search(Integer[] mas ,int start_index,int end_index, int x){
        int start = start_index;
        int end = end_index;
        int tmp;
        while(true){
            tmp = (start+end) /2;
            if(mas[tmp] == x){
                return tmp;
            }
            else if(start == end -1){
                return -1;
            }
            else if(mas[tmp] > x){
                end = tmp;
            }
            else {
                start = tmp;
            }
        }
    }
}
public class Main {
    public static void main(String[] args)throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print ("Enter vertical size: ");
        int vertical_size = scanner.nextInt();
        System.out.print ("Enter horizontal size: ");
        int horizontal_size = scanner.nextInt();
        ////////////// create matrix
        Integer[][] mas = MatrixBuilder.build(vertical_size,horizontal_size);
        System.out.println ("new matrix: ");
        NumberFormat format1 = NumberFormat.getInstance();
        format1.setMinimumIntegerDigits(3);
        Matrix.show(mas,format1);
        //////////////////// sort matrix
        Arrays.sort(mas, new matrixComparator());
        System.out.println ("new matrix: ");
        Matrix.show(mas,format1);
        ///////////////////////// formats
        System.out.print("enter string number: ");
        int x = scanner.nextInt();
        System.out.printf("%nnumber format: ");
        NumberFormat format2 = NumberFormat.getNumberInstance();
        for(int i = 0; i < horizontal_size;i++){
            System.out.print(" "+ format2.format(mas[x][i]));
        }

        System.out.printf("%npercent format: ");
        format2 = NumberFormat.getPercentInstance();
        for(int i = 0; i < horizontal_size;i++){
            System.out.print(" "+ format2.format(mas[x][i]));
        }
        System.out.printf("%nmoney format: ");
        format2 = NumberFormat.getCurrencyInstance();
        for(int i = 0; i < horizontal_size;i++){
            System.out.print(" "+ format2.format(mas[x][i]));
        }
        ////////////// sort
        System.out.printf ("%nEnter start index: ");
        int start_index = scanner.nextInt();
        System.out.print ("Enter end index: ");
        int end_index = scanner.nextInt();
        Arrays.sort(mas[0],start_index, end_index, new basicComparator());
        System.out.printf("%nnew string 1: %n");
        format2 = NumberFormat.getNumberInstance();
        for(int i = 0; i < horizontal_size;i++){
            System.out.print(" "+ format2.format(mas[0][i]));
        }
        //////////////full sort
        Arrays.sort(mas[0],0, horizontal_size, new basicComparator());
        System.out.printf("%nnew full sorted string 1: %n");
        for(int i = 0; i < horizontal_size;i++){
            System.out.print(" "+ format2.format(mas[0][i]));
        }
        System.out.printf ("%nEnter what you want to find: ");
        Integer find = scanner.nextInt();
        //int found = mybinary.search(mas[0],0,horizontal_size,find);
        int found =Arrays.binarySearch(mas[0],0,horizontal_size,find,new basicComparator());
        if(found == -1){
            System.out.printf ("doesnt exist!");
        }
        else {
            System.out.printf ("its number is %d",found+1);
        }
    }

}