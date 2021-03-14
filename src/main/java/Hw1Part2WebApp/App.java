package Hw1Part2WebApp;

import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }

    public static boolean searchForSumOfNums(ArrayList<Integer> list, Integer number1, Integer number2, Integer number3) {
        int sum = number1 + number2 + number3;
        if (list == null || list.size() == 0 || number1 < 0 || number2 < 0 || number3 < 0) {
            return false;
        }

        for (int element : list) {
            if (element < 0) {
                return false;
            }

            if (element == sum) { 
              return true;
            }
        }
        return false;
      }
}