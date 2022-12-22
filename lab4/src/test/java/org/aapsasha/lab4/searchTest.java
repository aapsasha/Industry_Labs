package org.aapsasha.lab4;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

class searchTest {

    @Test
    @Name("test 1")
    void russian1() {
        ArrayList<String> data = new ArrayList<String>();
        data.add("человек");
        String[] myAnswer = search.Russian(data);
        String[] answer = {"человек"};
        assertArrayEquals(myAnswer,answer);
    }
    @Test
    @Name("test 2")
    void russian2() {
        ArrayList<String> data = new ArrayList<String>();
        data.add("человек");
        data.add("паук");
        data.add("друг");
        String[] myAnswer = search.Russian(data);
        String[] answer = {"человек","паук","друг"};
        assertArrayEquals(myAnswer,answer);
    }
    @Test
    @Name("test 3")
    void russian3() {
        ArrayList<String> data = new ArrayList<>();
        data.add("человек");
        data.add("english");
        data.add("паук");
        data.add("halfрусский");
        data.add("друг");
        String[] myAnswer = search.Russian(data);
        String[] answer = {"человек","паук","друг"};
        assertArrayEquals(myAnswer,answer);
    }
}