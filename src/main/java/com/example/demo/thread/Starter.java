package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Starter {

    public static void main(String[] args) throws Exception {

        // Создаем объект ExecutorService с фиксированным пулом потоков (5 потоков)
        // ExecutorService - интерфейс, предоставляющий высокоуровневые методы
        // для управления и выполнения задач в фоновых потоках
        // Фоновые потоки (или фоновые процессы) — потоки выполнения, работающие
        // в фоновом режиме и обычно не требующие прямого взаимодействия с юзером.
        // Выполняются в фоне, независимо от основных операций или задач, которые
        // выполняются в приложении
        ExecutorService es = Executors.newFixedThreadPool(5);

        // 1 способ запустить поток, который выполнит задачу, указанную в классе MyRunnable
        // es.execute(new MyRunnable());

        // 2 способ запустить поток, который выполнит задачу, указанную в классе MyRunnable
        Future<Integer> sub = es.submit(new MyCallable());

        Thread.sleep(1000);

        // Метод cancel в интерфейсе Future используется для попытки отмены выполнения задачи.
        // Если передаем в метод true, и задача уже выполняется, то она может быть прервана
        // (прерван её поток выполнения), если false, и задача уже выполняется, то отмена
        // не будет произведена, и метод вернет false.
        // Метод возвращает true, если задача отменена, и false в противном случае.
        // Даже если метод вернул true, это не гарантирует, что задача отменена, т.к. она могла
        // завершиться до момента вызова cancel.
        // Эффективность отмены зависит от того, как реализована задача и поддерживает ли она отмену.
        // Некоторые задачи могут быть неотменяемыми или могут игнорировать запрос на отмену.
        sub.cancel(true);
        System.out.println(sub.isCancelled());

//        while (!sub.isDone()) {
//            System.out.println("Is not done");
//            Thread.sleep(1000);
//        }

        // Метод get() ожидает завершения выполнения задачи и возвращает результат выполнения
        // (или выбрасывает исключение, если задача завершится с ошибкой) - пока этот метод
        // не выполнится (т.е. пока не будет получен результат выполнения задачи), код,
        // расположенный после этого метода, не начнет выполняться
        // Строка sub.get(): вызов get() блокирует текущий поток (основной поток) до тех пор,
        // пока задача, представленная объектом MyRunnable, не завершится
//        Integer id = sub.get();
//        System.out.println(id);

        System.out.println("Shutdown");
        // Завершаем работу исполнителя (пула потоков)
        es.shutdown();
    }
}

// Создаем задачу для потока
// 1 способ - можно сделать это, используя интерфейс Runnable
//class MyRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        try {
//            System.out.println("Started: " + Thread.currentThread().getId());
//            Thread.sleep(2500);
//            System.out.println("Finished: " + Thread.currentThread().getId());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//}

// 2 способ - можно сделать это, используя интерфейс Callable
class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        try {
            System.out.println("Started: " + Thread.currentThread().getId());
            Thread.sleep(5000);
//            long d1 = System.currentTimeMillis();
//            long d2 = System.currentTimeMillis();
//            while (d2 < d1 + 5000) {
//                d2 = System.currentTimeMillis();
//            }
            System.out.println("Finished: " + Thread.currentThread().getId());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return 99;
    }
}
