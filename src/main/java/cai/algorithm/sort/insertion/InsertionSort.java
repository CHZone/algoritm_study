package cai.algorithm.sort.insertion;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    SortTestHelper.swap(arr, j, j - 1);
//                } else {
//                    break;// 漏掉了
//                }
//            }
            // 简洁写法
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortTestHelper.swap(arr, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 1000);
        SortTestHelper.performance(InsertionSort.class.getName(), arr);
    }
}
