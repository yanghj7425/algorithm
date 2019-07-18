package com.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程搜索
 */
@Slf4j
public class MulThreadSearch {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer arr[] = {1, 2, 6, 4, 45, 8, 23, 23, 56};
        int threadNum = 2;
        int slotSize = arr.length / 2;
        int searchValue = 23;

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < threadNum; i++) {
            list.add(executorService.submit(new SearchTask(arr, i * slotSize, (i + 1) * slotSize, searchValue)));
        }

        executorService.shutdown();

        for (Future<Integer> future : list) {
            log.info("result = {}", future.get());
        }

        log.info("executorService shutdown  status is {}", executorService.isShutdown());
        log.info("executorService terminal status is {}", executorService.isTerminated());


    }
}
