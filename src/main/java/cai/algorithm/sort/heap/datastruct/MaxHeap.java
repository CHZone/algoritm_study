package cai.algorithm.sort.heap.datastruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {
    private final Logger logger = LoggerFactory.getLogger(MaxHeap.class);
    protected T[] data;
    protected Integer count;
    protected int capacity;

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(T[] arr){
        data = (T[]) new Comparable[arr.length+1];
        count = arr.length;
        for(int i = 0; i<arr.length;i++){
            data[i+1] = arr[i];
        }
        heapify();
    }
    
    public void heapify(){
        for(int i = count/2;i > 0; i--){
            shiftDown(i);
        }
    }
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count.equals(0);
    }

    protected void swap(T[] arr,int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void insert(T e) {
        if (capacity <= count) {
            logger.error("Max Heap is full！！！");
        }
        data[++count] = e;
        shiftUp(count);// 漏掉，导致建堆错误。
    }

    protected void shiftUp(int k) {
        // 如果比父节点大就与父节点交换；注意边界
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            swap(this.data,k, k / 2);
            k = k / 2;
        }
    }
    public T pop(){
        if(this.isEmpty()){
            logger.error("Max Heap 已经为空了");
        }
        T tmp = data[1];
        data[1]=data[count];
        shiftDown(1);
        count--;
        return tmp;
    }
    protected void shiftDown(int k){
        while(2*k<=count){
            int j = 2*k;
            //与左右子节点中大的比较
            if (j+1 <= count && data[j].compareTo(data[j+1])<0){
                j = j+1;
            }
            if(data[k].compareTo(data[j])<0){
                swap(this.data,k,j);
                k = j;//漏掉，导致死循环
            }else{//大于左右子节点 shiftDown结束
                break;
            }
            
        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());
    }

}