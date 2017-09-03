package cai.algorithm.sort.insertion;

public class AdvanceInsertSort {
    /**
     * 移位操作使用到的变量个数和赋值次数都比交换操作
     * 为毛偶尔也会不未优化的花费的时间多了。
     * 交换操作的赋值次数是移位操作的3倍。但是如果arr有序则此处反而赋值的次数较多，没有优势。
     */
    public static <T extends Comparable<T>> void sort(T[] arr){
        for(int i = 1; i<arr.length; i++){
            int j = i;
            T tmp = arr[i];
            // 错写成 arr[j].compareTo(arr[j-1])
            for(; j > 0 && tmp.compareTo(arr[j-1]) < 0; j--){
                arr[j] = arr[j-1];
            }
            arr[j]=tmp;
        }
    }
}
