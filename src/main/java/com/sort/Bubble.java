package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 冒泡
 */
public class Bubble {

    public static void main(String[] args) {
        Integer arr[] = {1, 2, 6, 4, 45, 8, 4, 23, 56};
        sort(arr);
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.forEach(System.out::println);
    }


    public static void sort(Integer[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] > arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
