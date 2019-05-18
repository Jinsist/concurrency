package com.jinsist.concurrency.example.threadLocal;

/**
 * ThreadLocal
 * 可以简化参数传递，通过过滤器取出request中的必要参数。放入ThreadLocal，在使用时获取。最终在拦截器时afterCompletion中remove掉
 * @author Jinsist
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
