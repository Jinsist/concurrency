package com.jinsist.concurrency.example.publishobject;

import com.jinsist.concurrency.annoations.ThreadSafe;

/**
 * 饿汉式发布对象
 * @author Jinsist
 */
@ThreadSafe
public class SingletonExample1 {

    private SingletonExample1() {

    }

    private static SingletonExample1 singletonExample1 = new SingletonExample1();

    public static SingletonExample1 getInstance() {
        return singletonExample1;
    }
}
