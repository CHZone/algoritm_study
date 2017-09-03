package cai.algorithm.sort.quick;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class QuickSortRandom {
    public static <T extends Comparable<T>> void sort(T[] arr){
        quickSort(arr,0,arr.length);
    }
    
    public static <T extends Comparable<T>> void quickSort(T[] arr,int l, int r){
        if(l>=r){
            return;
        }
        int p = partion(arr,l,r);
        quickSort(arr,l,p);
        quickSort(arr,p+1,r);
    }
    
    public static <T extends Comparable<T>> int partion(T[] arr,int l,int r){
        int index = (int)(Math.random()*(r-l)+l);
        SortTestHelper.swap(arr, l, index);
        T e = arr[l];
        int sl = l+1;
        int sr = l+1;
        // [sl,sr), [sr,r)
        for (int i = l+1; i< r; i++ ){
            if (arr[i].compareTo(e) < 0){
                SortTestHelper.swap(arr, sr, i);//把sr写成sl
                sr++;
            }
        }
        SortTestHelper.swap(arr, l, sr-1);
        return sr-1;
    }

}
