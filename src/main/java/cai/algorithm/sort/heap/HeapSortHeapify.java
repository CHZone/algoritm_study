package cai.algorithm.sort.heap;

import cai.algorithm.sort.heap.datastruct.MaxHeap;

/**
 * 堆排序优化1：优化建堆过程，heapify，将n个数据的shiftUp 变成n/2个数据的shiftDown
 */
public class HeapSortHeapify {
    public static <T extends Comparable<T>> void sort(T[] arr){
        MaxHeap<T> maxheap = new MaxHeap<>(arr);
        for(int i = arr.length-1; i > -1; i--){
            arr[i] = maxheap.pop();
        }
    }
}
