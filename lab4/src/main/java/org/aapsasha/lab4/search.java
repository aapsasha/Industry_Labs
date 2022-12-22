package org.aapsasha.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class search {
    public static  String[] Russian(ArrayList<String> string_list) {
        String Rus = "йцукенгшщзхъфывапролджэячсмитьбюёЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ";
        String[] array_rus = new String[100];
        int rus_size = 0;
        for (String g : string_list) {
            boolean suit = true;
            for (int j = 0; j < g.length(); ++j) {
                if (Rus.indexOf(g.charAt(j)) == -1) {
                    suit = false;
                    break;
                }
            }
            if (suit) {
                array_rus[rus_size++] = g;
            }
        }
        array_rus = Arrays.copyOf(array_rus, rus_size);
        return array_rus;

    }
}
