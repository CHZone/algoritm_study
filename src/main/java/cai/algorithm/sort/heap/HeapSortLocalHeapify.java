package cai.algorithm.sort.heap;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

/**
 * 不使用堆数据结构
 */
public class HeapSortLocalHeapify {
    public static <T extends Comparable<T>> void sort(T[] arr){
        for(int i = (arr.length-2)/2; i >= 0; i--){
            shiftDown(arr,i,arr.length);
        }
        
        for(int i = 0;i < arr.length-1; i++){
            SortTestHelper.swap(arr, 0, arr.length-i-1);
            shiftDown(arr,0,arr.length-i-1);
        }
    }
    
    public static <T extends Comparable<T>> void shiftDown(T[] arr,int k,int size){
        T tmp = arr[k];
        while(2*k+1 < size){
            int j = 2*k+1;
            if(j+1<size && arr[j+1].compareTo(arr[j])>0){
                j = j+1;
            }
            if(tmp.compareTo(arr[j])<0){// 错误：把tmp写成了 arr[k]
                arr[k] = arr[j];// swap 该为移位
                k = j;
            }else{
                break;
            }
        }
        arr[k] = tmp;
    }
    
    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.printArray(arr);
        for(int i = (arr.length-2)/2; i >= 0; i--){
            shiftDown(arr,i,arr.length);
        }
        SortTestHelper.printArray(arr);
        
        for(int i = 0;i < arr.length-1; i++){
            SortTestHelper.swap(arr, 0, arr.length-i-1);
            shiftDown(arr,0,arr.length-i-1);
        }
        
        SortTestHelper.printArray(arr);
    }
    
}
