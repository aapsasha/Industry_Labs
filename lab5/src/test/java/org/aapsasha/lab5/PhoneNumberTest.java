package org.aapsasha.lab5;

import jdk.jfr.Name;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    @Name("my phone number")
    void match() {
        String line = "+375333256155";
        assertTrue(PhoneNumber.match(line));
    }

    @Test
    @Name("Test 1")
    void match1() {
        String line = "+375291234567";
        assertTrue(PhoneNumber.match(line));
    }

    @Test
    @Name("Test 2")
    void match2() {
        String line = "375291234567";
        assertTrue(PhoneNumber.match(line));
    }

    @Test
    @Name("Test 3")
    void match3() {
        String line = "+375204012345";
        assertFalse(PhoneNumber.match(line));
    }
}