package com.jinsist.concurrency.example.publishobject;

import com.jinsist.concurrency.annoations.ThreadSafe;

/**
 * 懒汉式发布对象
 * @author Jinsist
 */
@ThreadSafe
public class SingletonExample3 {

    private SingletonExample3() {

    }

    // 禁止重排序
    // 1.分配空间   2.创建对象  3.指向
    private static volatile SingletonExample3 singletonExample3;

    public static SingletonExample3 getInstance() {
        // 双重检查机制
        if(singletonExample3 == null) {
            synchronized (SingletonExample3.class) {
                if(singletonExample3 == null) {
                    singletonExample3 = new SingletonExample3();
                }
            }
        }
        return singletonExample3;
    }
}
