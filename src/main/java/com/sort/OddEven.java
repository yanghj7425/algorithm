package com.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 奇偶
 */
public class OddEven {
    public static void main(String[] args) {
        Integer arr[] = {1, 2, 6, 4, 45, 8, 4, 23, 56};
        sort(arr);
        List<Integer> list = Arrays.asList(arr);
        list.forEach(System.out::println);
    }


    public static void sort(Integer[] arr) {
        boolean isExchange = true;
        int start = 1;

        while (isExchange || start == 0) {
            isExchange = false;
            for (int i = start; i < arr.length - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    isExchange = true;
                }
            }
            if (start == 1) {
                start = 0;
            } else {
                start = 1;
            }
        }


    }

}
