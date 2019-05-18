package com.jinsist.concurrency.example.publishobject;

import com.jinsist.concurrency.annoations.NotRecommend;
import com.jinsist.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape( ) {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            // 直接使用this的值(此时未真正构造完成，不能直接使用发布使用--线程不安全)
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
