package com.jinsist.concurrency.example.publishobject;

/**
 * 通过枚举保证单例
 * @author Jinsist
 */
public class SingletonExample4 {

    // 私有构造函数
    private SingletonExample4() {

    }

    public static SingletonExample4 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample4 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample4();
        }

        public SingletonExample4 getInstance() {
            return singleton;
        }
    }
}
