package com.jinsist.concurrency.example;

import com.jinsist.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAddr--原子类
 * 对于普通的long、double变量，JVM允许将64位的读操作或写操作拆为2个32位的读操作或写操作
 * LongAdder核心是将热点数据分离，比如将AtomicLong的内部核心数据Value分离成一个数组，每个线程访问时通过Hash等算法将其中一个数字计数
 * 最终数组结果求和累加。其中热点数据value被分为多个单元的cell，每个cell独立维护内部的值，当前对象的值由实际数组所有值累加获得。
 * 缺点：统计时若有并发更新可能会导致统计数据出现误差
 * 高并发处理计数时可以优先使用LongAddr，而不是AtomicLong
 * 线程低可以使用Atomic，更快一些
 * 序列号生成准确数组全局唯一时使用AtomicLong
 */
@Slf4j
@ThreadSafe
public class LongAdder003 {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}", count);
        executorService.shutdown();
    }

    private static void add() {
        count.increment();
    }
}
