package cai.algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort {

    /**
     * [l, r)
     * 
     * @param arr
     * @param l
     * @param r
     */
    public static <T extends Comparable<T>> void partialSort(T[] arr, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        // 经典错误，l+r可能越界
        int mid = l+(r-l) / 2;
        partialSort(arr, l, mid);
        partialSort(arr, mid, r);
        merge(arr, l,mid, r);
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int l, int mid,int r) {
        // 1. 备份要merge的数据
        T[] tmp = Arrays.copyOf(arr, r - l);// new T[r-l] 不能这么写？
        for (int i = 0; i < r - l; i++) {
            tmp[i] = arr[l + i];
        }
        // 2. merge操作
        int i = 0;
        int j = (l+r)/2-l;// 容易出错，j = mid - l 比较保险
        if (arr[mid].compareTo(tmp[j])!=0){
            System.out.println("mid 求解错误！！！");
        }
        for (int k = l; k < r; k++) {
            // 左半边越界处理
            if (i >= mid-l) {
                arr[k] = tmp[j];
                j++;
                // 右半边越界处理
            } else if (j >= r-l) {
                arr[k] = tmp[i];
                i++;
            } else if (tmp[i].compareTo(tmp[j]) < 0) {
                arr[k] = tmp[i];
                i++;
            } else {
                arr[k] = tmp[j];
                j++;
            }
        }
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        partialSort(arr, 0, arr.length);
    }
}
