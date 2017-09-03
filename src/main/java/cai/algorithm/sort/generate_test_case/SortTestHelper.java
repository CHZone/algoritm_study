package cai.algorithm.sort.generate_test_case;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SortTestHelper {
    /**
     * 
     * @param n
     * @param rangeL
     * @param rangeR
     * @return 整型数组数据范围 [rangeL,rangeR]
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }
        return arr;
    }
    
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){
        Integer [] arr = new Integer[n];
        for (int i = 0; i< n; i++){
            arr[i] = i;
        }
        
        for(int i = 0; i< swapTimes; i++){
            int k = (int)(Math.random()*n);
            int j = (int)(Math.random()*n);
            swap(arr,k,j);
        }
        return arr;
    }
    
    public static void printArray(Object arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> boolean checkOrder(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void performance(String sortClassName, T[] arr) {
        Class sortClass;
        try {
            sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort", new Class[] { Comparable[].class });
            Object[] params = new Object[] { arr };
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            if(checkOrder(arr) == false){
                System.out.println(sortClass.getSimpleName() + " dose not work!!!");
            }
            if(arr.length< 30){
                SortTestHelper.printArray(arr);
            }
            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void swap(Object[] arr, int i, int j) {
        if( i >= 0 && i <= arr.length && i >= 0 && i <= arr.length){
           
            Object tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }else{
            System.out.println("swap faild!!!");
        }
    }

}
