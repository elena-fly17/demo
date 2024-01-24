package com.example.demo.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Starter2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Starter3 starter3 = new Starter3();
        Future<String> future = starter3.calculateAsync();
        System.out.println(future.get());
    }
}

class Starter3{

    public Future<String> calculateAsync() {
        // Создаем экземпляр CompletableFuture
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        // Создается и запускается кэшированный пул потоков - он динамически
        // увеличивает или уменьшает число потоков в зависимости от нагрузки
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            // Поток засыпает на полсекунды
            Thread.sleep(500);
            // Поток завершает работу и возвращает ее результат - строку "Hello" -
            // именно эту строку можно будет потом достать из CompletableFuture
            // как результат работы потока
            completableFuture.complete("Hello");
            // В данном контексте, оператор return null в лямбда-выражении, переданном
            // в метод submit для выполнения асинхронной задачи, является допустимым
            // способом завершения выполнения задачи
            return null;
        });
        // Останавливаем работу пула потоков
        executorService.shutdown();

        // ЭТО ВАРИАНТ ИЗ БАЕЛДУНГА - НО ПРИ ЕГО ИСПОЛЬЗОВАНИИ ЯВНО НЕ ОСТАНАВЛИВАЛСЯ
        // ПУЛ ПОТОКОВ - И ПОЭТОМУ ПРОИСХОДИЛА СУЩЕСТВЕННАЯ ЗАДЕРЖКА В ОСТАНОВКЕ РАБОТЫ
        // ПРИЛОЖЕНИЯ ПОСЛЕ ТОГО, КАК ВСЕ ЗАДАЧИ БЫЛИ УЖЕ ВЫПОЛНЕНЫ
//        Executors.newCachedThreadPool().submit(() -> {
//            // Поток засыпает на полсекунды
//            Thread.sleep(500);
//            // Поток завершает работу и возвращает ее результат - строку "Hello" -
//            // именно эту строку можно будет потом достать из CompletableFuture
//            // как результат работы потока
//            completableFuture.complete("Hello");
//            // В данном контексте, оператор return null в лямбда-выражении, переданном
//            // в метод submit для выполнения асинхронной задачи, является допустимым
//            // способом завершения выполнения задачи
//            return null;
//        });
        return completableFuture;
    }
}
