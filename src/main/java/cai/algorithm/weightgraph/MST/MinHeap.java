package cai.algorithm.weightgraph.MST;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.sort.insertion.InsertionSort;

/**
 * @author chzone 最小堆，辅助计算最小生成树
 */
public class MinHeap<Item extends Comparable> {
    private final static Logger logger = LoggerFactory.getLogger(MinHeap.class);
    public Item[] data;
    protected int count;
    protected int capacity;

    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MinHeap(Item[] arr) {
        int n = arr.length;
        data = (Item[]) new Comparable[n + 1];
        count = arr.length;
        this.capacity = n;
        for(int i = 0; i< n; i++){
            data[i+1] = arr[i];
        }
        heapify(this.data);
    }
    
    /**
     * @param arr
     *  arr[0] 不保存元素
     */
    public void heapify(Item[] arr){
        for (int i = arr.length / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    /**
     * @param k
     *            如过k比左右还在大，则下移
     */
    public void shiftDown(int k) {
        Item tmp = data[k];
        while (k * 2 <= count) {
            int j = k * 2;
            if (j+1<=count &&data[j].compareTo(data[j + 1]) > 0) {
                j = j + 1;
            }
            if (tmp.compareTo(data[j]) > 0) {
                data[k] = data[j];
                k = j;
            } else {
                break;
            }
        }
        data[k] = tmp;
    }
    
    public int size(){
        return count;
    }
    
    public boolean isEmpty(){
        return count==0;
    }
    
    public void insert(Item item){
        count++;
        data[count] = item;
        shiftUp(count);
    }
    
    public void shiftUp(int k){
        Item tmp = data[k];
        while(k>1){
            if(tmp.compareTo(data[k/2])<0){
                data[k] = data[k/2];// 漏掉了
                k = k/2;
            }else{
                break;
            }
        }
        data[k] = tmp;
    }
    
    public Item getMin(){
        return data[1];
    }
    
    public Item extractMin(){
        if(isEmpty()){
            logger.error("最小堆已经为空");
            return null;
        }
        Item item = data[1];
        data[1] = data[count];
        count--;
        shiftDown(1);
        return item;
    }
    
    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr, N);
        SortTestHelper.printArray(arr);
        MinHeap<Integer> mh = new MinHeap<>(arr);
        for(int i = 0; i< N;i++){
            System.out.print(mh.extractMin()+" ");
        }
        System.out.println();
        InsertionSort is = new InsertionSort();
        is.sort(arr2);
        SortTestHelper.printArray(arr2);
        
    }

    public Item[] getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }
    
}
