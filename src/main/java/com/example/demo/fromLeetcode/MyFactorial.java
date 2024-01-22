package com.example.demo.fromLeetcode;

// ВЫЧИСЛЕНИЕ ФАКТОРИАЛА С ПОМОЩЬЮ ЦИКЛА - ЭТО ЛУЧШЕ РЕКУРСИИ
public class MyFactorial {

    public int getFactorial(int a) {

        if(a == 0) {
            return 1;
        }

        int currentValue = 1;

        for (int i = 1; i <= a; i++) {
            currentValue = currentValue * i;
        }

        return currentValue;
    }
}
