package cai.algorithm.sort.merge;

import java.util.Arrays;

public class AdvanceMergeSort {
    public static <T extends Comparable<T>> void sort(T[] arr,int l,int r){
        if(r-l<=1){
            return;
        }
        int mid = (r+l)/2;
        sort(arr,l,mid);
        sort(arr,mid,r);
        if(arr[mid-1].compareTo(arr[mid])<=0){
            return;
        }
        merge(arr,l,mid,r);
    }
    
    public static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r){
       T[] tmp = Arrays.copyOfRange(arr, l,r);
       
       int i = 0;
       int j = m-l;
       for(int k = l ;k < r; k++){
           if(i>=m-l){
               arr[k] = tmp[j];
               j++;
           }else if(j >= r-l){
               arr[k] = tmp[i];
               i++;
           }else if(tmp[i].compareTo(tmp[j]) < 0){
               arr[k] = tmp[i];
               i++;
           }else{
               arr[k] = tmp[j];
               j++;
           }
       }
    }
    
    public static <T extends Comparable<T>> void sort(T[] arr){
        sort(arr,0,arr.length);
    }
}
