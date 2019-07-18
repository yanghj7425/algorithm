package com.search;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
class SearchTask implements Callable<Integer> {
    private AtomicInteger result = new AtomicInteger(-1);

    private Integer[] arr;

    private int start;
    private int end;

    private Integer target;


    public SearchTask(Integer[] arr, int start, int end, Integer searchValue) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.target = searchValue;
    }


    private Integer search() {
        int store = result.get();
        if (store > 0) {
            return store;
        }
        for (int i = start; i < end; i++) {
            if (target == arr[i]) {
                if (!result.compareAndSet(-1, i)) {
                    log.info("target value {} has find one", target);
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer call() {
        return search();
    }
}