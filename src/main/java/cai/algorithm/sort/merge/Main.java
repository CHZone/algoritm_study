package cai.algorithm.sort.merge;

import java.util.Arrays;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.sort.selection.SelectionSort;

public class Main {
    public static void main(String [] args){
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        
        SortTestHelper.performance(AdvanceMergeSort.class.getName(), arr2);
        SortTestHelper.performance(MergeSort.class.getName(), arr);
        SortTestHelper.performance(SelectionSort.class.getName(), arr1);
        SortTestHelper.performance(MergeSortBU.class.getName(), arr3);
        
    }
}
