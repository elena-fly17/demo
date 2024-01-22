package com.example.demo.reflection_examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {

    // Рассмотрим пример того, что можно делать с помощью рефлексии - то, что не можем делать
    // без нее - например, можем создать файл (у нас это файл test100.txt), в котором укажем
    // имя метода и параметры для него, и напишем код, который будет читать этот файл и вызывать
    // указанный в нем метод с переданными в него параметрами, указанными в файле
    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Сумма " + a + " и " + b + " = " + result);
    }

    void subtraction(int a, int b) {
        int result = a - b;
        System.out.println("Разница " + a + " и " + b + " = " + result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("Произведение " + a + " и " + b + " = " + result);
    }

    void division(int a, int b) {
        int result = a / b;
        System.out.println("Частное " + a + " и " + b + " = " + result);
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("test100.txt"))) {
            // Читаем строки из файла
            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            // Создаем объект Class от нашего калькулятора
            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();

            // Создаем некий метод
            Method method = null;
            // Теперь в нашем классе Calculator нам нужно найти метод, указанный в файле -
            // для этого получаем список всех методов, объявленных в классе Calculator
            Method[] methods = cl.getDeclaredMethods();
            // И находим среди них нужный
            for (Method myMethod : methods) {
                if(myMethod.getName().equals(methodName)) {
                    method = myMethod;
                }
            }
            // Далее вызываем найденный нужный метод с помощью метода invoke - в параметрах
            // метода invoke первым элементом указываем объект, на котором будет вызван этот метод,
            // а затем указываем параметры, которые нужно передать в вызываемый метод
            method.invoke(calculator, Integer.parseInt(firstArgument),
                    Integer.parseInt(secondArgument));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
