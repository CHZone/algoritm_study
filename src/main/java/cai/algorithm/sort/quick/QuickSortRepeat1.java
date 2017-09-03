package cai.algorithm.sort.quick;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

/**
 * @author chzone
 *平均分配重复元素
 */
public class QuickSortRepeat1 {
    public static <T extends Comparable<T>> void sort(T[] arr){
        quickSort(arr,0,arr.length);
    }
    public static <T extends Comparable<T>> void quickSort(T[] arr,int l ,int r){
        if(l+1>=r){// 忘记递归终止条件
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p);
        quickSort(arr,p+1,r);
    }
    /**
     * 两路partition
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static <T extends Comparable<T>> int partition(T[] arr,int l ,int r){
        int index = (int)(Math.random()*(r-l)+l);
        SortTestHelper.swap(arr, index, l);
        int lt = l+1;
        int gt = r;
        // 小于等于e 的区间为 [l+1,lt),大于等于e的区间为 [gt,r) 
        while(lt < gt){
            // 为毛不是i<gt
            while(lt<r&&arr[lt].compareTo(arr[l])<0){
                lt++;
            }
            // 为毛不是 gt> lt   gt 初始化错误
            while(gt>l+1&& arr[gt-1].compareTo(arr[l])>0){
                gt--;
            }
            if(lt < gt-1){
//                System.out.println(lt+":"+gt);
                SortTestHelper.swap(arr, lt, gt-1);
                gt--;
                lt++;
            }else{
                break;
            }
        }
        SortTestHelper.swap(arr, l,gt-1);
        return gt-1;
    }
}
