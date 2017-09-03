package cai.algorithm.sort.quick;

import java.util.Arrays;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.sort.insertion.AdvanceInsertSort;
import cai.algorithm.sort.insertion.InsertionSort;
import cai.algorithm.sort.merge.AdvanceMergeSort;
import cai.algorithm.sort.merge.MergeSort;
import cai.algorithm.sort.selection.SelectionSort;

public class Main {
    public static void main(String[] args){
        int N = 15;//15665为最大迭代深度，有序是也可能在quickSort挂掉
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);
        Integer[] arr6 = Arrays.copyOf(arr, arr.length);
//        SortTestHelper.printArray(arr);
        System.out.println("完全随机");
        SortTestHelper.performance(SelectionSort.class.getName(), arr);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr1);
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr2);
        SortTestHelper.performance(QuickSort.class.getName(), arr3);
        SortTestHelper.performance(QuickSortRandom.class.getName(), arr4);
        SortTestHelper.performance(QuickSortRepeat1.class.getName(), arr5);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr6);
        
        System.out.println("完全有序");
        arr = SortTestHelper.generateNearlyOrderedArray(N, 0);
        arr1 = Arrays.copyOf(arr, arr.length);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        arr4 = Arrays.copyOf(arr, arr.length);
        arr5 = Arrays.copyOf(arr, arr.length);
        arr6 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.performance(SelectionSort.class.getName(), arr);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr1);
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr2);
        SortTestHelper.performance(QuickSort.class.getName(), arr3);
        SortTestHelper.performance(QuickSortRandom.class.getName(), arr4);
        SortTestHelper.performance(QuickSortRepeat1.class.getName(), arr5);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr6);

        
        System.out.println("几乎有序");
        arr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        arr1 = Arrays.copyOf(arr, arr.length);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        arr4 = Arrays.copyOf(arr, arr.length);
        arr5 = Arrays.copyOf(arr, arr.length);
        arr6 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.performance(SelectionSort.class.getName(), arr);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr1);
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr2);
        SortTestHelper.performance(QuickSort.class.getName(), arr3);
        SortTestHelper.performance(QuickSortRandom.class.getName(), arr4);
        SortTestHelper.performance(QuickSortRepeat1.class.getName(), arr5);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr6);
        
        
        System.out.println("大量重复数据");
        arr = SortTestHelper.generateRandomArray(N, 1,5);
        arr1 = Arrays.copyOf(arr, arr.length);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        arr4 = Arrays.copyOf(arr, arr.length);
        arr5 = Arrays.copyOf(arr, arr.length);
        arr6 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.performance(SelectionSort.class.getName(), arr);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr1);
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr2);
        SortTestHelper.performance(QuickSort.class.getName(), arr3);
        SortTestHelper.performance(QuickSortRandom.class.getName(), arr4);
        SortTestHelper.performance(QuickSortRepeat1.class.getName(), arr5);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr6);
        
        
    }
}
