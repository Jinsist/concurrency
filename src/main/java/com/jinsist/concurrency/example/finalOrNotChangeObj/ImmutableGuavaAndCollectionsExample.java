package com.jinsist.concurrency.example.finalOrNotChangeObj;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * 不可变对象
 * @author Jinsist
 */
public class ImmutableGuavaAndCollectionsExample {

    /**
     * Collections创建不可变对象
     * Guava工具类创建普通对象、不可变对象
     */

    // 1.陈列元素创建
    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    // 2.拷贝创建
    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    // 3.Map--k,v-k,v式创建
    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    // 4.map建造者模式--不可变对象
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).build();

    public static void main(String[] args) {
        Map<Integer, Integer> map3 = Maps.newHashMap();
        // 将Map变为不可修改的Map
        Map<Integer, Integer> integerIntegerMap = Collections.unmodifiableMap(map3);
        // put会抛异常，因为不可修改
        integerIntegerMap.put(1, 4);
    }
}
