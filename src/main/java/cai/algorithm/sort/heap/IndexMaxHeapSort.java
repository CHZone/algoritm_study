package cai.algorithm.sort.heap;

import cai.algorithm.sort.heap.datastruct.IndexMaxHeap;

public class IndexMaxHeapSort {
    public static <T extends Comparable<T>> void sort(T[] arr){
        IndexMaxHeap<T> imh = new IndexMaxHeap<>(arr.length);// 这个地方不能写成IndexMaxHeap<Integer>
        for(int i = 0; i < arr.length; i++){
            imh.insert(i,arr[i]);
        }
        for(int i = arr.length-1; i>=0; i--){
            arr[i] = imh.pop();
        }
    }
}
