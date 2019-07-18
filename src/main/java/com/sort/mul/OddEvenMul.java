package com.sort.mul;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 奇偶排序多线程版本
 */
public class OddEvenMul {

    private boolean isExchange = true;


    public static void main(String[] args) throws InterruptedException {

        Integer arr[] = {1, 2, 6, 4, 45, 8, 4, 23, 56};
        OddEvenMul oddEvenMul = new OddEvenMul();
        oddEvenMul.sort(arr);
        List<Integer> list = Arrays.asList(arr);
        list.forEach(System.out::println);
    }


    void sort(Integer[] arr) throws InterruptedException {
        int start = 0;
        int threadNum = arr.length / 2 - start;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        while (isIsExchange() || start == 1) {
            setIsExchange(false);
            CountDownLatch latch = new CountDownLatch(threadNum);
            for (int i = start; i < arr.length - 1; i += 2) {
                executorService.submit(new OddEventSortTask(arr, i, latch));
            }
            latch.await();
            if (start == 1) {
                start = 0;
            } else {
                start = 1;
            }
        }
        executorService.shutdown();
    }

    public class OddEventSortTask implements Runnable {

        private int idx;
        private CountDownLatch latch;
        private Integer[] arr;

        public OddEventSortTask(Integer[] arr, int idx, CountDownLatch latch) {
            this.arr = arr;
            this.idx = idx;
            this.latch = latch;
        }

        @Override
        public void run() {
            if (arr[idx] < arr[idx + 1]) {
                int temp = arr[idx];
                arr[idx] = arr[idx + 1];
                arr[idx + 1] = temp;
                setIsExchange(true);

            }
            latch.countDown();
        }
    }


    public synchronized boolean isIsExchange() {
        return this.isExchange;
    }

    public synchronized void setIsExchange(boolean isExchange) {
        this.isExchange = isExchange;
    }
}
