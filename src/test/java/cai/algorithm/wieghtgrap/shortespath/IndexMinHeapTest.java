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
        //Integer[] data = imh.getData();
        
        SortTestHelper.printArray(arr);
        for(int i = 0; i<N;i++){
            System.out.print(arr[imh.extractMin()]+",");
            // 检测Count
            assertEquals(imh.getCount(), N-i-1);
            // 检测是否依然满足堆的定义
            assertEquals(checkHeap(imh),true);
            int[] indexes = imh.getIndexes();
            int[] reverse = imh.getReverse();
            // 检测每次去除后的index中-1的位置
            assertEquals(indexes[indexes.length-i-1], -1);
            //和reverse中的-1的个数。
            assertEquals(checkReverse(reverse), i+1+1);
        }
    }
    
    public static int  checkReverse(int[] arr){
        int count = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i]==-1){
                count++;
            }
        }
        return count;
    }
    /**
     * 检测change
     */
    @Test
    public void testChange(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        IndexMinHeap<Integer> imh = new IndexMinHeap<>(arr.length);
        for(int i = 0; i< arr.length;i++){
            imh.insert(i, arr[i]);
        }
        for(int i = 0;i<N; i++){
            int index = (int)(Math.random()*(N-1));
            int a = (int)(Math.random()*N);
            imh.change(index, a);
            assertEquals(checkHeap(imh), true);
        }
        
        
    }
    
}
