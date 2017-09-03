package cai.algorithm.sort.quick;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class QuickSort {
    /**
     * @param arr
     */
    public static <T extends Comparable<T>> void sort(T[] arr){
        quickSort(arr,0,arr.length);
    }
    
    public static <T extends Comparable<T>> void quickSort(T[] arr,int l, int r){
        if(l>=r){
            return;
        }
        int p = partion(arr,l, r);
        quickSort(arr,l,p);
        quickSort(arr,p+1,r);
    }
    
    public static <T extends Comparable<T>> int partion(T[] arr,int l,int r){
        T tmp = arr[l];// 需改进的地方
        // 小于tmp的边界 [sl,sr)
        int sl = l+1;
        int sr = l+1;
        // 大于(等于)tmp的边界[sr,i)
        for(int i = l+1; i < r; i++){
            if (arr[i].compareTo(tmp) < 0){
                SortTestHelper.swap(arr, i, sr);
                sr++;
            }
        }
        SortTestHelper.swap(arr, l, sr-1);
        return sr-1;
    }
    
}
