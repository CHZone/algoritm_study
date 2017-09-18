package cai.algorithm.weightgraph.shortestpath;

public class IndexMinHeap<T extends Comparable> {
    private T[] data;
    private int[] indexes;
    private int[] reverse;
    private int capacity;
    private int count;

    public IndexMinHeap(int capacity) {
        this.capacity = capacity;
        count = 0;
        data = (T[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i < capacity + 1; i++) {
            indexes[i] = reverse[i] = -1;
        }
    }

    public void insert(int i, T item) {
        i++;
        data[i] = item;
        count++;
        indexes[count] = i;
        reverse[i] = count;
        shiftUp(count);
    }

    public void shiftUp(int k) {
        int tmp = indexes[k];
        while (k > 1) {
            if (data[tmp].compareTo(data[indexes[k / 2]]) < 0) {
                indexes[k] = indexes[k / 2];
                reverse[indexes[k]] = k;
                k = k / 2;
            } else {
                break;
            }
        }
        indexes[k] = tmp;
        reverse[indexes[k]] = k;
    }

    /**
     * @return 索引
     */
    public int extractMin() {
        int ret = indexes[1];
        // 删除堆顶元素
        reverse[indexes[1]] = -1;
        // indexes[1] = -1;
        // 移动堆尾元素
        indexes[1] = indexes[count];
        reverse[indexes[1]] = 1;
        indexes[count] = -1;
        count--;
        shiftDown(1);
        return ret-1;
    }

    public void shiftDown(int k) {
        if(count == 0){
            // count == 0 s是 ，
            //indexes[1]==-1
            // 此时reverse[indexes[1]] 会指针越界。
            return ;
        }
        int tmp = indexes[k];
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j]].compareTo(data[indexes[j + 1]]) > 0) {
                j++;
            }
            if (data[tmp].compareTo(data[indexes[j]]) > 0) {
                indexes[k] = indexes[j];
                reverse[indexes[k]] = k;
                k = j;
            } else {
                break;
            }
        }
        indexes[k] = tmp;
        reverse[indexes[k]] = k;

    }
    
    public void change(int i ,T item){
        i++;
        data[i] = item;
        shiftUp(i);
        shiftDown(i);
    }

    public T[] getData() {
        return data;
    }

    public int[] getIndexes() {
        return indexes;
    }

    public int[] getReverse() {
        return reverse;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return count;
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    public boolean contains(int v){
        return reverse[v]!=-1;
    }
}
