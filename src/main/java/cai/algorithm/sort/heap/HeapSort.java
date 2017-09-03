package cai.algorithm.sort.heap;

import cai.algorithm.sort.heap.datastruct.MaxHeap;

public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int capacity = arr.length;
        MaxHeap<T> maxheap = new MaxHeap<>(capacity);
        for (int i = 0; i < capacity; i++) {
            maxheap.insert(arr[i]);
        }

        for (int i = capacity - 1; i >=0; i--) {
            arr[i] = maxheap.pop();
        }

    }
}
