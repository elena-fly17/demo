package com.example.demo.reflection_examples;

import java.lang.reflect.Field;

public class Ex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // Важный момент: если в классе Employee закомментим геттер и сеттер, касающиеся поля salary,
        // и закомментим конструктор, через который можно было указать salary, то получается,
        // что теперь из-за инкапсуляции никак не добраться до поля salary, ведь оно private -
        // Но рефлексия нарушает этот принцип и все равно позволяет добраться до такого поля -
        // Итак, как это сделать: создаем обычный объект Employee
        Employee employee = new Employee(10, "Zaur", "IT");
        // Получаем объекта типа Class на созданном нами объекте Employee - можно было получить его и
        // другим способом (например, с использованием метода forName)
        Class employeeClass = employee.getClass();
        // Затем получаем доступ к нужному полю
        Field field = employeeClass.getDeclaredField("salary");
        // В строке ниже мы объявляем, что хотим получить доступ к полю, даже если оно private
        field.setAccessible(true);
        // А теперь значение из полученного поля запишем в какую-нибудь переменную
        double salaryValue = (Double)field.get(employee);
        System.out.println(salaryValue);

        // Также через рефлексию можно изменить значение private-поля - для этого в метод set
        // передаем объект, значения private-поля которого хотим изменить, и новое значение
        field.set(employee, 1500);
        System.out.println(employee);
    }
}
