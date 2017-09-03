
package cai.algorithm.sort.selection;

import java.util.Arrays;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.sort.insertion.AdvanceInsertSort;
import cai.algorithm.sort.insertion.InsertionSort;

public class Main {
    public static void main(String[] args) {
        int N = 20;
        System.out.println("Test for random array ,size = "+N+",random range[0,"+N+"]");
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = Arrays.copyOf(arr,arr.length);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        SortTestHelper.performance(AdvanceInsertSort.class.getName(), arr2);
        SortTestHelper.performance(InsertionSort.class.getName(), arr1);
        SortTestHelper.performance(SelectionSort.class.getName(), arr);
        
//        System.out.println("Test for nearly ordered array,size = " +N+", range[0, "+N+"]");
//        Integer[] arr3 = SortTestHelper.generateNearlyOrderedArray(N, 10);
//        Integer[] arr4 = Arrays.copyOf(arr3, arr3.length);
//        Integer[] arr5 = Arrays.copyOf(arr3, arr3.length);
//        SortTestHelper.performance(AdvanceInsertionSort.class.getName(), arr3);
//        SortTestHelper.performance(InsertionSort.class.getName(), arr4);
//        SortTestHelper.performance(SelectionSort.class.getName(), arr5);
//        
//        System.out.println("Test for nearly ordered array,size = " +N+", range[0, "+N+"]");
//        Integer[] arr6 = SortTestHelper.generateNearlyOrderedArray(N, 100);
//        Integer[] arr7 = Arrays.copyOf(arr6, arr3.length);
//        Integer[] arr8 = Arrays.copyOf(arr6, arr3.length);
//        SortTestHelper.performance(AdvanceInsertionSort.class.getName(), arr6);
//        SortTestHelper.performance(InsertionSort.class.getName(), arr7);
//        SortTestHelper.performance(SelectionSort.class.getName(), arr8);
        
        
    }
}
