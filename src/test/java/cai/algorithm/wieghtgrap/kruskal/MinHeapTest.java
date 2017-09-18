package cai.algorithm.wieghtgrap.kruskal;

import static org.junit.Assert.*;

import org.junit.Test;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.weightgraph.kruskal.MinHeap;

public class MinHeapTest {
    public static boolean checkMinHeap(MinHeap mh){
        int count = mh.getCount();
        Comparable[] data = mh.getData();
        for(int i = count; i>1;i--){
            if(data[i].compareTo(data[i/2])<0){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testInsert(){
       int N = 7;
       Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
       MinHeap<Integer> mh = new MinHeap<>(arr.length);
       for(int i = 0; i< arr.length;i++){
           mh.insert(arr[i]);
           assertEquals(checkMinHeap(mh),true);
           assertEquals(mh.getCount(), i+1);
       }
    }
    @Test
    public void testExtract(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        MinHeap<Integer> mh = new MinHeap<>(arr);
        assertEquals(checkMinHeap(mh), true);
        for(int i = 0; i< N; i++){
            System.out.println(mh.extractMin());
            assertEquals(checkMinHeap(mh), true);
            assertEquals(mh.getCount(), N-i-1);
        }
    }
}
