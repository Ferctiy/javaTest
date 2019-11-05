package com.example.demo.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName thread
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/9/5 17:07
 * @Version 1.0
 */
public class DemoThread {
    /**
     * 线程池使用
     */
    private static Executor executor = Executors.newFixedThreadPool(50);
    public void threadTest(){
        for (int i=1;i<10;i++){
            try {
                AtomicInteger integer = new AtomicInteger();
                integer.set(i);
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->runDod(integer.get()),executor);
                future.get();
                System.out.println("future.get() = " + future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public Integer runDod(int i){
        System.out.println("executor"+i);
        return 1;
    }

}
