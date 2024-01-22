package com.example.demo.reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class employeeClass = Class.forName("com.example.demo.reflection_examples.Employee");

        // Теперь создадим объект класса Employee с помощью объекта employeeClass
        // Сначала используем конструктор без параметров
        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Employee obj1 = constructor1.newInstance();
        // Теперь создадим объект класса Employee через конструктор с 3 параметрами - обрати
        // внимание: ниже создаем объект Object, выше создали сразу объект Enployee - можно и
        // так и так - способ выбирайте в зависимости от ваших нужд и логики кода
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class,
                String.class);
        Object obj2 = constructor2.newInstance(5, "Zaur", "IT");
        System.out.println(obj2);

        System.out.println("****************");

        // Теперь с помощью рефлексии вызовем какой-нибудь метод их нужного нам класса
        // Сначала создаем нужный метод
        Method method = employeeClass.getMethod("setSalary", double.class);
        // Теперь запускаем этот метод с помощью метода invoke - в invoke передаем некоторые
        // параметры - первым из них является объект, на котором хотим вызвать нужный нам метод,
        // вторым является тот или те (их может быть несколько) параметр, который нужно передать
        // в вызываемый метод (у нас вызываемый метод setSalary принимает один параметр - зарплату,
        // которую хотим установить для работника)
        method.invoke(obj2, 800.88);
        System.out.println(obj2);




    }
}
