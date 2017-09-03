package cai.algorithm.sort.quick;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class QuickSort3Ways {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        quickSort3Ways(arr, 0, arr.length);
    }

    public static <T extends Comparable<T>> void quickSort3Ways(T[] arr, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int[] p = partition(arr, l, r);
        quickSort3Ways(arr, l, p[0]);
        quickSort3Ways(arr, p[1], r);
    }

    public static <T extends Comparable<T>> int[] partition(T[] arr, int l, int r) {
        int index = (int) (Math.random() * (r - l) + l);
        SortTestHelper.swap(arr, index, l);
        int lt = l + 1;
        int i = l + 1;
        int gt = r;
        // 小于，等于，大于区间分别为
        // [l+1,lt),[lt,i),[gt,r)
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {// 把l 写成index,md好一顿找啊！！！
                SortTestHelper.swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                SortTestHelper.swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        SortTestHelper.swap(arr, l, lt - 1);
        lt--;
        return new int[] { lt, gt };
    }

    public static void main(String[] args) {
        int N = 3;// 15665为最大迭代深度，有序是也可能在quickSort挂掉
        for (int i = 0; i < 1000; i++) {
            Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
            sort(arr);
            if (!SortTestHelper.checkOrder(arr)) {
                System.out.println("=============================");
                SortTestHelper.printArray(arr);
            }
        }
    }
}
