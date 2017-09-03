package cai.algorithm.search.binary_search;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.sort.quick.QuickSort3Ways;

public class BinarySearch {
    public static <T extends Comparable<T>> int search(T[] arr, T target){
        int l = 0; 
        int r = arr.length;
        int mid = l + (r-l)/2;// 二分搜索坑一： int mid = (r+l)/2 溢出
        while(l<r){
            if(arr[mid].compareTo(target)==0){
                return mid;
            }else if(arr[mid].compareTo(target)>0){
                r = mid;
            }else{
                l = mid+1;
            }
            mid = l + (r-l)/2;
        }
        return -1;
    }
    
    public static void main(String [] args){
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        SortTestHelper.performance(QuickSort3Ways.class.getName(), arr);
        System.out.println(0+":"+search(arr, arr[0]));
        System.out.println((arr.length/2+1)+":"+search(arr,arr[arr.length/2+1]));
        System.out.println((arr.length-1)+":"+search(arr, arr[arr.length-1]));
    }
}
