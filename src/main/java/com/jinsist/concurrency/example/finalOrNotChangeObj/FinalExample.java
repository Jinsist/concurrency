package com.jinsist.concurrency.example.finalOrNotChangeObj;

import com.google.common.collect.Maps;
import com.jinsist.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * final使用
 * @author Jinsist
 */
@Slf4j
@NotThreadSafe
public class FinalExample {

    /**
     * final修饰的基本变量，不能修改
     * final修饰的引用变量，不能更改其指向
     * final修饰形参，其在函数中也不可更改其指向(区分基本变量还是对象)
     */
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));

        int c = 1;
        test(c);
    }

    private static void test(final int value) {
        // final修饰的形参不可更改值
//        value = 2;
    }
}
