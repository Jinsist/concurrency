package com.jinsist.concurrency.example.publishobject;

import com.jinsist.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    // 若固定数据请不要使其能对该数据更改。
    private String[] states = { "a", "b", "c"};

    // 任何线程访问可以对该发布对象数据修改，线程不安全
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
