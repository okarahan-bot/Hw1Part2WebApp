package Hw1Part2WebApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class AppTest {
    @Test void testFindsSum() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40));
        assertTrue(App.searchForSumOfNums(list, 2, 3, 5));
    }

    @Test void testNotFindsSum() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40));
        assertFalse(App.searchForSumOfNums(list, 2, 3, 4));
    }

    @Test void testNullArr() {
        assertFalse(App.searchForSumOfNums(null, 2, 3, 5));
    }

    @Test void testEmptyArr() {
        ArrayList<Integer> list = new ArrayList<>();
        assertFalse(App.searchForSumOfNums(list, 2, 3, 4));
    }

    @Test void testInvalidArguments() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-10,20,30,40));
        assertFalse(App.searchForSumOfNums(list, 2, 3, 4));
        list = new ArrayList<>(Arrays.asList(10,20,30,40));
        assertFalse(App.searchForSumOfNums(list, 2, -3, 4));
    }
}
