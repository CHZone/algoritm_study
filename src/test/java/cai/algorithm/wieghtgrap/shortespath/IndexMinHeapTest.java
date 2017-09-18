package cai.algorithm.wieghtgrap.shortespath;

import static org.junit.Assert.*;

import org.junit.Test;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.weightgraph.shortestpath.IndexMinHeap;

public class IndexMinHeapTest {
    public static <T extends Comparable> boolean  checkHeap(IndexMinHeap<T> imh){
        T[] data = imh.getData();
        int[] indexes = imh.getIndexes();
        int count = imh.getCount();
        for(int i = count; i>1; i--){
            if(data[indexes[i]].compareTo(data[indexes[i/2]])<0){
                return false;
            }
        }
        return true;
    }
    @Test
    public  void testInsertMinHeap(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        IndexMinHeap<Integer> imh = new IndexMinHeap<>(arr.length);
        for(int i = 0; i<N;i++){
            imh.insert(i, arr[i]);
            assertEquals(imh.getCount(),i+1);
            assertEquals(checkHeap(imh),true);
        }
    }
    @Test
    public void testExtract(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        IndexMinHeap<Integer> imh = new IndexMinHeap<>(arr.length);
        for(int i = 0; i < N; i++){
            imh.insert(i, arr[i]);
        }
        for(int i = 0; i<N;i++){
            System.out.print(imh.extractMin()+",");
            assertEquals(imh.getCount(), N-i-1);
            assertEquals(checkHeap(imh),true);
        }
    }
}
