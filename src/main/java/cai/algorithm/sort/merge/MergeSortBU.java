package cai.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSortBU {
    public static <T extends Comparable<T>> void sort(T[] arr){
        for(int sz = 1; sz < arr.length; sz +=sz){
            for (int l = 0;l+sz < arr.length; l +=2*sz){
                merge(arr,l,l+sz,(l+2*sz>arr.length)?arr.length:l+2*sz);
            }
        }
    }
    
    public static<T extends Comparable<T>> void merge(T[] arr,int l,int mid,int r){
        T[] tmp = Arrays.copyOfRange(arr, l, r);
        
        int i = 0;
        int j = mid-l;
        for(int k = l ; k < r; k++){
            if(i >= mid-l){
                arr[k]=tmp[j];
                j++;
            }else if(j >= r-l){
                arr[k] = tmp[i];
                i++;
            }else if(tmp[i].compareTo(tmp[j])<0){
                arr[k] = tmp[i];
                i++;
            }else{
                arr[k] = tmp[j];
                j++;
            }
        }
                
        
    }
}
