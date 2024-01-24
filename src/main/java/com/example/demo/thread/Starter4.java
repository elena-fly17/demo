package com.example.demo.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Starter4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Future<String> completableFuture = CompletableFuture.completedFuture("Hello");
//        System.out.println(completableFuture.get());

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
//        System.out.println(future.get());

//        CompletableFuture<String> completableFuture = CompletableFuture
//                .supplyAsync(() -> "Hello");
//        CompletableFuture<String> future = completableFuture
//                .thenApply(s -> s + " World");
//        System.out.println(future.get());

//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<Void> future = completableFuture
//                .thenAccept(s -> System.out.println("Computation returned: " + s));
//        System.out.println(future.get());

//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<Void> future = completableFuture
//                .thenRun(() -> System.out.println("Computation finished."));
//        System.out.println(future.get());

//        CompletableFuture<String> completableFuture = CompletableFuture
//                .supplyAsync(() -> "Hello")
//                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
//        System.out.println(completableFuture.get());

//        CompletableFuture<String> completableFuture = CompletableFuture
//                .supplyAsync(() -> "Hello")
//                .thenCombine(CompletableFuture.supplyAsync(
//                        () -> " World"), (s1, s2) -> s1 + s2);
//        System.out.println(completableFuture.get());

//        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
//                        (s1, s2) -> System.out.println(s1 + s2));


    }
}
