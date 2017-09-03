package cai.algorithm.sort.heap.datastruct;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class IndexMaxHeapRev<T extends Comparable<T>> {
    private final Logger logger = LoggerFactory.getLogger(IndexMaxHeapRev.class);
    private T data [];
    private Integer[] indexes;
    private Integer[] reverse;
    private int count;
    private int capacity;
    public IndexMaxHeapRev(int capacity){
        data = (T[])new Comparable[capacity+1];
        indexes = new Integer[capacity+1];
        reverse = new Integer[capacity+1];
        for(int i = 1; i< reverse.length;i++){
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }
    
    public IndexMaxHeapRev(T[] arr){
        data = (T[])new Comparable[arr.length+1];
        indexes = new Integer[arr.length+1];
        reverse = new Integer[arr.length+1];
        for(int i = 1; i< reverse.length; i++){
            indexes[i]=reverse[i] = i;//忘记初始化indexes
            data[i] = arr[i-1];// 忘记初始化data
        }
        count = arr.length;
        capacity = arr.length;
        heapify();
    }
    
    private void heapify(){
        for(int i = count/2; i > 0; i--){
            shiftDown(i);
        }
    }
    /**
     * 避免在同一个地方重复插入导致indexes中有两个元素指向同一个data[i]
     * 但是有可能插入失败
     * 在插入之前需要判断有哪些地方可以插入。找位置太麻烦也耗时。
     * @param i
     * @param e
     */
    public int insert(int i,T e){
        if(count == capacity){
            logger.error("rev 堆已经满了！！！");
            return -1;
        }
        if(i+1 > capacity){
            logger.error("插入的位置越界了。");
            return -1;
        }
        if(contain(i)){
            logger.error("====rev在"+i+"位置已经有元素了！！！");
            return -1;
        }
        
        data[i+1] = e;
        
        count++;
        indexes[count] = i+1;
        reverse[i+1] = count;
        shiftUp(count);      
        
        return i;
    }
    
    public void shiftUp(int k){
        int tmp = indexes[k];
        while(k > 1){
            if(data[tmp].compareTo(data[indexes[k/2]]) >0){
                indexes[k] = indexes[k/2];
                reverse[indexes[k]] = k;
                k = k/2;
            }else{
                break;
            }
        }
        indexes[k]=tmp;
        reverse[tmp] = k;
    }
    
    public T pop(){
        if(count < 1){
            logger.error("Index Max Heap Reverse is Empty");
            
        }
        int tmp = indexes[1];
        indexes[1] = indexes[count];
        reverse[indexes[1]] = 1;
        count--;
        shiftDown(1);
        return data[tmp];
        
    }
    /**
     * 移位改进
     * @param k
     */
    public void shiftDown(int k){
        int tmp = indexes[k];
        while(2*k <= count){
            int j = 2*k;
            if(j+1<=count && data[indexes[j]].compareTo(data[indexes[j+1]])<0){
                j = j+1;
            }
            if(data[tmp].compareTo(data[indexes[j]])<0){
                indexes[k]=indexes[j];
                reverse[indexes[k]] = k;
                k = j;
            }else{// 漏掉了break;
                break;
            }
        }
        indexes[k]=tmp;
        reverse[tmp] = k;
    }
    
    
    public void change(int i ,T e){
        if(!contain(i)){
            logger.error("此处没有元素");
        }
        i++;
        data[i] = e;
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }
    
    public boolean contain(int i){
        if(i+1 > capacity){
            logger.error("索引越界了！");
        }
        return reverse[i+1] != 0;
    }
    
    public static void main(String[] args){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        IndexMaxHeapRev<Integer> imhr1 = new IndexMaxHeapRev(arr.length);
        for(int i = 0; i < arr.length; i++){
            imhr1.insert(i, arr[i]);
        }
        IndexMaxHeapRev<Integer> imhr2 = new IndexMaxHeapRev(arr1);
        SortTestHelper.printArray(imhr1.indexes);
        SortTestHelper.printArray(imhr2.indexes);
        
    }
    
}
