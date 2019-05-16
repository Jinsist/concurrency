package com.jinsist.concurrency.example;

import com.jinsist.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater
 * @author Jinsist
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdater005 {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdater005> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdater005.class, "count");

    // 使用AtomicIntegerFieldUpdater更新字段必须加volatile修饰
    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater005 example5 = new AtomicIntegerFieldUpdater005();
        if(updater.compareAndSet(example5, 100,120)) {
           log.info("1----count:{}", example5.getCount());
        }
        if(updater.compareAndSet(example5, 100,120)) {
            log.info("2-----count:{}", example5.getCount());
        } else {
            log.info("3-----count:{}", example5.getCount());
        }
    }
}
