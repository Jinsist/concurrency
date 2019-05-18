package com.jinsist.concurrency.example.synchronizedContainer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.assertj.core.util.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 同步容器
 * @author Jinsist
 */
public class synchronizedContainer {

    // 同步容器
    private static List<Integer> list = Collections.synchronizedList(Lists.newArrayList());

    private static Set<String> set = Collections.synchronizedSet(Sets.newHashSet());

    private static Map<String, Object> map = Collections.synchronizedMap(Maps.newHashMap());
}
