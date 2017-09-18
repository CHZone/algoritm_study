package cai.algorithm.wieghtgrap.MST;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cai.algorithm.sort.generate_test_case.SortTestHelper;
import cai.algorithm.weightgraph.optimizedMST.IndexMinHeap;

public class TestIndexMeanHeap {
    
    public static <T extends Comparable> boolean checkHeapIndexes(IndexMinHeap<T> imh){
        T[] data = imh.getData();
        Integer[] indexes = imh.getIndexes();
        Integer[] reverse = imh.getReverse();
        int count = imh.getCount();
        for(int i = count; i>1; i++ ){
            if(data[indexes[count]].compareTo(data[indexes[count/2]])<0){
                return false;
            }
        }
        return true;
    }
    
    public static <T extends Comparable> boolean checkHeapReverse(IndexMinHeap<T> imh){
        T[] data = imh.getData();
        Integer[] indexes = imh.getIndexes();
        Integer[] reverse = imh.getReverse();
        int count = imh.getCount();
        for(int i = count; i >=1; i--){
//            System.out.println("i="+i+", reverse[indexes["+i+"]]="+reverse[indexes[i]]);
            if(reverse[indexes[i]] != i){
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void TestcreateIndexMeanHeap(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        IndexMinHeap<Integer> imh = new IndexMinHeap<>(arr.length);
        for(int i = 0; i< arr.length; i++){
            imh.insert(i, arr[i]);
        }
        
        assertEquals(checkHeapIndexes(imh),true);
        assertEquals(checkHeapReverse(imh), true);
    }
    @Test
    public void TestExtract(){
        int N = 7;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        IndexMinHeap<Integer> imh = new IndexMinHeap<>(arr.length);
        for(int i = 0; i <arr.length; i++){
            imh.insert(i, arr[i]);
        }
        SortTestHelper.printArray(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[imh.extractMin()]+",");
            assertEquals(checkHeapIndexes(imh), true);
            assertEquals(checkHeapReverse(imh), true);
            assertEquals(imh.getCount(), arr.length-i-1);
            
        }
    }
    @Test
    public void testChange(){
        // TO
    }
}
