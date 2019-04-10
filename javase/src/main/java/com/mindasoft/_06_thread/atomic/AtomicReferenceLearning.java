package com.mindasoft._06_thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: min
 * @date: 2019/4/10 11:38
 * @version: 1.0.0
 */
public class AtomicReferenceLearning {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);
    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        count.compareAndSet(0, 1); // no
        count.compareAndSet(1, 3); // no
        count.compareAndSet(2, 4); // 4
        count.compareAndSet(3, 5); // no
        System.out.println("count:" + count.get());
    }
}
