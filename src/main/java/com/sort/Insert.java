package com.sort;

import java.util.Arrays;
import java.util.List;

public class Insert {

    public static void main(String[] args) {
        Integer arr[] = {1, 2, 6, 4, 45, 8, 4, 23, 56};
        sort(arr);
        List<Integer> list = Arrays.asList(arr);
        list.forEach(System.out::println);
    }


    public static void sort(Integer[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j] = temp;
        }


    }


}
