package cai.algorithm.weightgraph.optimizedMST;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class IndexMinHeap<Item extends Comparable> {
    private Item[] data;
    private Integer[] indexes;
    private Integer[] reverse;
    private int count;
    private int capacity;

    public IndexMinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexes = new Integer[capacity + 1];
        reverse = new Integer[capacity + 1];
        count = 0;
        this.capacity = capacity;
        for (int i = 0; i < capacity + 1; i++) {
            indexes[i] = reverse[i] = -1;
        }
    }

    public void insert(int i, Item item) {
        if (contain(i)) {
            return;
        }
        // 堆从1 开始保存数据
        i++;
        count++;
        data[i] = item;
        indexes[count] = i;
        reverse[i] = count;
        shiftUp(count);
    }

    /**
     *  如果 当前节点比父节点大则将父节点移动的当前位置。
     */
    public void shiftUp(int k) {
        int tmpk = indexes[k];// 写成了k
        if(tmpk<1){
            System.out.println("tmpk:"+tmpk+" k:"+k);
        }
        while (k > 1) {
            if (data[tmpk].compareTo(data[indexes[k / 2]]) < 0) {
                indexes[k] = indexes[k / 2];
                reverse[indexes[k]] = k;
                k = k / 2;
            } else {
                break;
            }
        }
        indexes[k] = tmpk;
        reverse[indexes[k]] = k;
    }

    public void shiftDown(int k) {
        int tmpk = indexes[k];
        while (2 * k <= count) {
            int j = 2 * k;
            // 选较小的数
            if (j + 1 <= count && data[indexes[j]].compareTo(data[indexes[j + 1]]) > 0) {// 写成了indexes[j+1]
                j = j + 1;
            }
            // 如果tmpk 比较大就 shiftDown
            if (data[tmpk].compareTo(data[indexes[j]]) > 0) {// 写成了data[indexes[tmpk]]
                indexes[k] = indexes[j];// 写成了j
                reverse[indexes[k]] = k;
                k = j;
            } else {
                break;
            }

        }
        indexes[k] = tmpk;
        reverse[indexes[k]] = k;
    }

    public boolean contain(int i) {
        return reverse[i + 1] != -1;
    }

    /**
     * 此处返回的不是边，而是 未加入的节点的号 ，及indexes[1]。而不是data[indexes[1]
     * @return
     */
    public int extractMin() {
//        Item item = data[indexes[1]];
        int ret = indexes[1];
        // 删除堆顶
        reverse[indexes[1]] = -1;//indexes[1]
        
        // 覆盖堆顶元素
        indexes[1] = indexes[count];
        reverse[indexes[1]] = 1;// 这会导致最后有一个1，而不是所有都是-10
        // 删除 indexes 的指向,
        shiftDown(1);
        indexes[count] = -1;
        count--;
        return ret-1;
    }

    public static void main(String[] args) {
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        IndexMinHeap<Integer> imh = new IndexMinHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            imh.insert(i, arr[i]);
        }
        SortTestHelper.printArray(arr);
        SortTestHelper.printArray(imh.data);
        SortTestHelper.printArray(imh.indexes);
        SortTestHelper.printArray(imh.reverse);
        System.out.println("==================");
        while( !imh.isEmpty()){
            System.out.print(imh.extractMin()+",");

        }
        System.out.println();
        System.out.println("===============");
        SortTestHelper.printArray(imh.indexes);
        SortTestHelper.printArray(imh.reverse);
        
        Math.pow(1, 1);
    }

    public void change(int k, Item item) {
        k++;
        data[k] = item;
        
        shiftUp(reverse[k]);// 写成了光杆k
        shiftDown(reverse[k]);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Item[] getData() {
        return data;
    }

    public Integer[] getIndexes() {
        return indexes;
    }

    public Integer[] getReverse() {
        return reverse;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }
    
    
}
