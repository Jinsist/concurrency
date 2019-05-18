package com.jinsist.concurrency.example.publishobject;

import com.jinsist.concurrency.annoations.ThreadSafe;

/**
 * 饿汉式发布对象
 * @author Jinsist
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {

    }

    private static SingletonExample2 singletonExample2;

    // 放在声明null之后
    static {
        singletonExample2 = new SingletonExample2();
    }


    public static SingletonExample2 getInstance() {
        return singletonExample2;
    }
}
