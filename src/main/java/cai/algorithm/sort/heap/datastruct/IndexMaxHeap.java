package cai.algorithm.sort.heap.datastruct;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

/**
 * 一次使用，主要用于排序。不适合任意元素插入和删除。
 * @param <T>
 */
public class IndexMaxHeap <T extends Comparable<T>> extends PrintableMaxHeap {
    final private static Logger logger = LoggerFactory.getLogger(IndexMaxHeap.class);
    private Integer[] indexes;

    public IndexMaxHeap(int capacity) {
        super(capacity);
        indexes = new Integer[capacity+1];
    }

    /**
     * 不能重复添加元素。
     * 
     * data 和 indexes都是从下标1开始存储 但外部而言data是从0开始存储。
     * 由于pop时没有data和indexes的的大小应该不是相同的。但是插入式缺失count++了？
     * 疑问1：如果i+1位置有数据且已经在堆中，重复添加操作会使得indexes中有两个位置的值指向data[i+1]
     */
    public void insert(int i, T e) {
        if (++i > capacity) {
            logger.error("============索引越界！！！！==============");
        }
        data[i] = e;
        indexes[++count] = i;
        shiftUp(i);
    }

    protected void shiftUp(int k) {
        while (k > 1) {
            // System.out.println(k+":"+indexes[k]+":"+indexes[k/2]);
            if (data[indexes[k]].compareTo(data[indexes[k / 2]]) > 0) {
                swap(indexes, k, k / 2);
                k = k / 2;
            } else {
                break;
            }
        }
    }

    /* 
     *  索引堆中pop元素时，data[indexes[1]]中并没有删除元素，这样一来，data中就会存在废弃空间。
     *  rev可以判断data[i]是否在对中，但要指定有哪些位置可以添加元素还是要遍历data
     *  
     *  难以维护的感觉。
     *  
     */
    public T pop(){
        T e = (T) data[indexes[1]];
        swap(indexes,1,count);
        count--;
        shiftDown(1);
        return e;
    }
    
    protected void shiftDown(int k){
        int tmp = indexes[k];
        while(2*k <= count){
            int j = 2*k;
            if (j+1 <=count &&data[indexes[j]].compareTo(data[indexes[j+1]])<0 ){
                j =  j+1;
            }
            if (data[tmp].compareTo(data[indexes[j]])<0){//把tmp 写成了indexes[k]
                indexes[k]=indexes[j];
                k = j;
            }else{
                break;
            }
        }
        indexes[k]=tmp;
    }
    
    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        IndexMaxHeap<Integer> imh = new IndexMaxHeap<>(30);
        SortTestHelper.printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            imh.insert(i, arr[i]);
        }

        SortTestHelper.printArray(imh.data);// 可以直接读取protected属性
        SortTestHelper.printArray(imh.indexes);
        
        for(int i = arr.length-1 ; i >=0; i--){
            arr[i]=imh.pop();
        }
        if(SortTestHelper.checkOrder(arr)){
            System.out.println("有序");
            SortTestHelper.printArray(arr);
        }else{
            System.out.println("无序");
            SortTestHelper.printArray(arr);
        }

    }

}
