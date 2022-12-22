package org.aapsasha.lab4;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainLab4 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter first string %n");
        String main_string = scanner.nextLine();
        System.out.printf("Enter second string %n");
        String separator = scanner.nextLine();

        //tokenise
        StringTokenizer lexeme = new StringTokenizer(main_string, separator);
        String[] string_array = new String[lexeme.countTokens()];
        //Stream<String> stream = Stream.generate(() -> lexeme.nextToken());
        ArrayList<String> string_list = new ArrayList<String>(0);
        for (int i = 0; lexeme.hasMoreTokens(); i++) {
            string_list.add(lexeme.nextToken());
        }

        // sort by lenght
        Collections.sort(string_list, (String a, String b) -> a.length() - b.length());

        // cout
        System.out.printf("LEXEMES: %n");
        string_list.stream().forEach((String a) -> System.out.println(String.format("%s", a)));

        // find binary numbers
        int[] int_array = new int[100];
        int int_array_size = 0;
        for (String g : string_list) {
            try {
                int_array[int_array_size] = Integer.parseInt(g, 2);
            } catch (NumberFormatException e) {
                --int_array_size;
            }
            ++int_array_size;
        }
        System.out.printf("BINIRY NUMBERS: %n");
        for (int j = 0; j < int_array_size; j++) {
            System.out.println(int_array[j]);
        }

        //find russian words
        String Rus = "йцукенгшщзхъфывапролджэячсмитьбюёЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ";

        String[] array_rus = search.Russian(string_list);
        int rus_size = array_rus.length;
        System.out.printf("RUSSIAN WORDS: %n");
        for(int i =0; i < rus_size; ++i){
            System.out.println(String.format("%s", array_rus[i]));
        }

        // find P
        String P;
        while(true){
            System.out.print("enter number P: ");
            P = scanner.next();
            try {
                int tmp = Integer.parseInt(P, 10);
                break;
            } catch (NumberFormatException e) {
                System.out.printf("it is not a number!%n");
                continue;
            }
        }

        Pattern pattern = Pattern.compile("([" + separator + "]|^)(" + P + ")([" + separator + "]|$)");
        Matcher matcher = pattern.matcher(main_string);
        StringBuffer main_string_buf = new StringBuffer(main_string);
        if (matcher.find()) {
            System.out.printf("it (first) position is %d %n", matcher.start() + 1);

            // insert -P
            Integer tmp = Integer.parseInt(P, 10);
            tmp *= -1;
            main_string_buf.insert(matcher.start() + P.length(), "  " + tmp.toString());
            System.out.print(String.format("new string with -P:%n%s%n", main_string_buf));
        }
        else
            System.out.printf("there is no such string! %n");

        //delete russian word
        //Pattern pattern2 = Pattern.compile("([" + separator + "]|^)([" + Rus + "]+)([" + separator + "]|$)");
        //Matcher matcher2 = pattern2.matcher(main_string_buf);
        //if(matcher2.find()) {
        //    System.out.printf("new string with less russian words:%n%s",matcher.replaceFirst(""));
        //}
        //else{
        //    System.out.printf("there is no russian words!%n");
        //}
        if(rus_size != 0){
            int start =main_string_buf.indexOf(array_rus[0]);
            System.out.printf("new string with less russian words:%n%s",main_string_buf.delete(start,start + array_rus[0].length()));
        }
    }

}
