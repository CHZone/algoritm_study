package cai.algorithm.weightgraph.kruskal;

public class  MinHeap<T extends Comparable> {
    private T[] data;
    private int count;
    private int capacity;
    public MinHeap(int capacity){
        data = (T[]) new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }
    
    public MinHeap(T[] arr){
        data = (T[]) new Comparable[arr.length+1];
        this.capacity=arr.length;
        this.count = arr.length;
        for(int i = 0; i<this.count; i++){
            data[i+1] = arr[i];
        }
        heapify();
    }
    private void heapify(){
        for(int i = count/2; i>0; i--){
            shiftDown(i);
        }
    }
    public void insert(T item){
        count++;
        data[count] = item;
        shiftUp(count);
        
    }
    private void shiftUp(int k){
        T tmp = data[k];
        while(k>1){
            if(tmp.compareTo(data[k/2])<0){
                data[k] = data[k/2];
                k = k/2;
            }else{
                break;
            }
        }
        data[k] = tmp;
    }
    
    public T extractMin(){
        T tmp = data[1];
        data[1]=data[count];
        count--;
        shiftDown(1);
        return tmp;
    }
    
    private void shiftDown(int k){
        T tmp = data[k];
        while(2*k <= count){
            int j = 2*k;
            if(j+1<=count&& data[j+1].compareTo(data[j])<0){
                j++;
            }
            if(tmp.compareTo(data[j])>0){
                data[k] = data[j];
                k = j;
            }else{
                break;
            }
        }
        data[k] = tmp;
    }

    public T[] getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public boolean isEmpty(){
        return count <= 0;
    }
    
}
