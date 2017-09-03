package cai.algorithm.sort.insertion;

import java.util.Arrays;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class Main {
    public static void main(String [] args){
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("Random");
        SortTestHelper.performance(InsertionSort.class.getName(), arr);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr1);
        
        arr = SortTestHelper.generateNearlyOrderedArray(N, 20);
        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("Ordered");
        SortTestHelper.performance(InsertionSort.class.getName(), arr);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr1);
        
    }
}
