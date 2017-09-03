package cai.algorithm.sort;

import java.util.Arrays;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.sort.heap.HeapSort;
import cai.algorithm.sort.heap.HeapSortHeapify;
import cai.algorithm.sort.heap.HeapSortLocalHeapify;
import cai.algorithm.sort.heap.IndexMaxHeapRevSort;
import cai.algorithm.sort.heap.IndexMaxHeapSort;
import cai.algorithm.sort.insertion.AdvanceInsertSort;
import cai.algorithm.sort.merge.AdvanceMergeSort;
import cai.algorithm.sort.quick.QuickSort3Ways;

public class Main {
    public static void main(String[] args) {
        int N = 50000;
        Integer [] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer [] arr1 = Arrays.copyOf(arr, arr.length);
        Integer [] arr2 = Arrays.copyOf(arr, arr.length);
        Integer [] arr3 = Arrays.copyOf(arr, arr.length);
        Integer [] arr4 = Arrays.copyOf(arr, arr.length);
        Integer [] arr5 = Arrays.copyOf(arr, arr.length);
        Integer [] arr6 = Arrays.copyOf(arr, arr.length);
        Integer [] arr7 = Arrays.copyOf(arr, arr.length);

        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr1);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr3);
        SortTestHelper.performance(HeapSort.class.getName(), arr2);
        SortTestHelper.performance(HeapSortHeapify.class.getName(), arr4);
        SortTestHelper.performance(HeapSortLocalHeapify.class.getName(), arr5);
        SortTestHelper.performance(IndexMaxHeapSort.class.getName(), arr6);
        SortTestHelper.performance(IndexMaxHeapRevSort.class.getName(), arr7);
        
        System.out.println("近乎有序");
        arr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        arr1 = Arrays.copyOf(arr, arr.length);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        arr4 = Arrays.copyOf(arr, arr.length);
        arr5 = Arrays.copyOf(arr, arr.length);
        arr6 = Arrays.copyOf(arr, arr.length);
        arr7 = Arrays.copyOf(arr, arr.length);
        
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr1);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr3);
        SortTestHelper.performance(HeapSort.class.getName(), arr2);
        SortTestHelper.performance(HeapSortHeapify.class.getName(), arr4);
        SortTestHelper.performance(HeapSortLocalHeapify.class.getName(), arr5);
        SortTestHelper.performance(IndexMaxHeapSort.class.getName(), arr6);
        SortTestHelper.performance(IndexMaxHeapRevSort.class.getName(), arr7);
        
        System.out.println("大量重复数据");
        
        arr = SortTestHelper.generateRandomArray(N, 0, 100);
        arr1 = Arrays.copyOf(arr, arr.length);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        arr4 = Arrays.copyOf(arr, arr.length);
        arr5 = Arrays.copyOf(arr, arr.length);
        arr6 = Arrays.copyOf(arr, arr.length);
        arr7 = Arrays.copyOf(arr, arr.length);
        
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr1);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr3);
        SortTestHelper.performance(HeapSort.class.getName(), arr2);
        SortTestHelper.performance(HeapSortHeapify.class.getName(), arr4);
        SortTestHelper.performance(HeapSortHeapify.class.getName(), arr5);
        SortTestHelper.performance(IndexMaxHeapSort.class.getName(), arr6);
        SortTestHelper.performance(IndexMaxHeapRevSort.class.getName(), arr7);
    }
}
