package com.example.demo.reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchFieldException,
            NoSuchMethodException {

        // Способы создания объекта Class
        // 1 способ - важно указать полный путь к классу - т.е. с пакетом, в котором он лежит
        Class employeeClass = Class.forName("com.example.demo.reflection_examples.Employee");
        // 2 способ
        // Class employeeClass2 = Employee.class;
        // 3 способ - сначала создаем обычный объект нужного класса (можно любой конструктор
        // использовать) - потом на созданном объекте вызываем метод getClass
//        Employee emp = new Employee();
//        Class employeeClass3 = emp.getClass();

        // С помощью объекта класса Class можно получить инфу о каком-нибудь поле нужного класса -
        // например, мы можем узнать тип этого поля
        Field someField = employeeClass.getField("id");
        System.out.println("Type of id field = " + someField.getType());
        System.out.println("********");
        // Также можно узнать информацию сразу обо всех полях - но обрати внимание: в консоль
        // выведется информация только о public-полях
        Field[] fields = employeeClass.getFields();
        for (Field field : fields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("********");
        // Но к private-полям тоже можно получить доступ с помощью рефлексии
        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }
        System.out.println("--------------------------------");

        // Теперь с помощью рефлексии получим информацию о методах класса
        // Сначала получим информацию о каком-нибудь одном методе - например, узнаем тип
        // возвращаемого им значения, типы его параметров
        Method someMethod1 = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary = " + someMethod1.getReturnType() +
                ", parameter types = " + Arrays.toString(someMethod1.getParameterTypes()));
        System.out.println("********");
        // Еще пример получения информации о методе
        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method setSalary = " + someMethod2.getReturnType() +
                ", parameter types = " + Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("********");

        // Теперь получим информацию обо всех методах класса Employee - примечательно то, что
        // в списке выводимых методов будут также и методы, унаследованные от родителей - в данном
        // случае от класса Object (методы wait, equals, hashCode, getClass, notify, notifyAll) -
        // но при этом не будут возвращены private-методы
        Method[] methods = employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println("Name of method = " + method.getName() + ", return type = " +
                    method.getReturnType() + ", parameter types = " +
                    Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("********");
        // Но все равно можем с помощью рефлексии получить данные и о private-методах - в этом
        // примере будут возвращены только те методы, которые непосредственно объявлены в классе
        // Employee, в т.ч. private-методы - но без методов, унаследованных от родителя
        Method[] allMethods = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println("Name of method = " + method.getName() + ", return type = " +
                    method.getReturnType() + ", parameter types = " +
                    Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("********");
        // С помощью рефлексии также можно получить список методов класса, в который войдут
        // только public-методы, но не войдут методы, унаследованные от родителя - для этого
        // получаем список всех методов, объявленных в классе (но без методов, унаследованных
        // от родителя) - затем у каждого из этих методов проверяем модификатор доступа
        // и выводим в консоль данные только о public-методах
        Method[] allMethods2 = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println("Name of method = " + method.getName() + ", return type = " +
                    method.getReturnType() + ", parameter types = " +
                    Arrays.toString(method.getParameterTypes()));
                }
            }
        System.out.println("********");
        System.out.println("--------------------------------");

        // Также с помощью рефлексии можно получать информацию о конструкторах класса
        // Сначала получим информацию о каком-то одном конкретном конструкторе - т.к. метод
        // getConstructor принимает varargs, то это значит, что можно передать в этот метод
        // сколько угодно параметров или не передать ничего - если ничего не передаем, то это
        // значит, что мы хотим получить информацию о конструкторе без параметров
        Constructor constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor has " + constructor1.getParameterCount() +
                " parameters, their types are: " +
                Arrays.toString(constructor1.getParameterTypes()));
        System.out.println("********");

        // Теперь получим информацию о конструкторе класса Employee с 3 параметрами - для этого
        // в метод getConstructor передаем параметры, которые принимает конструктор,
        // информацию о котором хотим получить
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class,
                String.class);
        System.out.println("Constructor has " + constructor2.getParameterCount() +
                " parameters, their types are: " +
                Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("********");

        // А теперь получим информацию обо всех конструкторах класса Employee
        Constructor[] constructors = employeeClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor " + constructor.getName() + " has " +
                    constructor.getParameterCount() + " parameters, their types are: " +
                    Arrays.toString(constructor.getParameterTypes()));
        }
    }
}
