package cai.algorithm.sort.heap;

import java.util.Arrays;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.sort.insertion.AdvanceInsertSort;
import cai.algorithm.sort.merge.AdvanceMergeSort;
import cai.algorithm.sort.quick.QuickSort3Ways;

public class Main {
    public static void main(String[] args) {
        int N = 20000;
        Integer [] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer [] arr1 = Arrays.copyOf(arr, arr.length);
        Integer [] arr2 = Arrays.copyOf(arr, arr.length);
        Integer [] arr3 = Arrays.copyOf(arr, arr.length);

        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr1);
        SortTestHelper.performance(HeapSort.class.getName(), arr2);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr3);
        
        System.out.println("近乎有序");
        arr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        arr1 = Arrays.copyOf(arr, arr.length);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr1);
        SortTestHelper.performance(HeapSort.class.getName(), arr2);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr3);
        
        
    }
}
