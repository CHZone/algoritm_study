package cai.algorithm.sort.heap;

import cai.algorithm.sort.heap.datastruct.IndexMaxHeapRev;

public class IndexMaxHeapRevSort {
    public static <T extends Comparable<T>> void sort(T[] arr){
        IndexMaxHeapRev<T> imhr = new IndexMaxHeapRev<>(arr.length);
        for(int i = 0; i < arr.length; i++){
            imhr.insert(i, arr[i]);
        }
        for(int i = arr.length-1; i>=0; i--){
            arr[i] = imhr.pop();
        }
    }
}
