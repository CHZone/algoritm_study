package cai.algorithm.wieghtgrap.MST;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.weightgraph.MST.MinHeap;

public class MinHeapTest {

    /**
     * @param mh
     * @return 编译通过，但是运行不同过，提示不能转成Integer 数组 ？ 为毛呢？？？
     */
    public static boolean checkMinHeap(MinHeap mh) {
        // 为毛不能转成 int 类型呢？
        Integer[] data = (Integer[]) mh.getData();
        for (int i = mh.size() / 2; i > 1; i--) {
            if (data[i].compareTo(data[2 * i]) > 0
                    || (2 * i + 1 <= mh.size() && data[i].compareTo(data[2 * i + 1]) > 0)) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable> boolean checkMinHeap2(MinHeap<T> mh) {
        // 为毛不能转成 int 类型呢？
        T[] data = mh.getData();
        for (int i = mh.size() / 2; i > 1; i--) {
            if (data[i].compareTo(data[2 * i]) > 0
                    || (2 * i + 1 <= mh.size() && data[i].compareTo(data[2 * i + 1]) > 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查插入完成后是否正确。
     */
    @Test
    public void testMinHeap() {
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        MinHeap<Integer> mh = new MinHeap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            mh.insert(arr[i]);
        }
        assertEquals(mh.getCapacity(), arr.length);
        assertEquals(mh.getCount(), arr.length);
        assertEquals(checkMinHeap2(mh), true);
        // assertEquals(false, true);
    }

    /**
     * 检查 每次插入后是否满足堆的定义，且count大小是否正确
     */
    @Test
    public void testMinHeapInsert() {
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        MinHeap<Integer> mh = new MinHeap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            mh.insert(arr[i]);
            assertEquals(mh.getCount(), i + 1);
            assertEquals(checkMinHeap2(mh), true);
        }
    }
    
    /**
     * 验证取数据后的结构
     */
    @Test
    public void testMianHeapInsert(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        MinHeap<Integer> mh = new MinHeap<>(arr.length);
        for(int i = 0; i <arr.length;i++){
            mh.insert(arr[i]);
        }
        for(int i = 0; i<arr.length; i++){
            System.out.println(mh.extractMin());
            assertEquals(checkMinHeap2(mh), true);
            assertEquals(mh.getCount(), arr.length-i-1);
        }
    }
    
    public void testMainHeapHeapify(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        MinHeap<Integer> mh = new MinHeap<>(arr);
        assertEquals(checkMinHeap2(mh), true);
        assertEquals(mh.getCapacity(), arr.length);
        assertEquals(mh.getCount(), arr.length);
    }
}
