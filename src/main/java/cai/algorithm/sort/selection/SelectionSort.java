package cai.algorithm.sort.selection;

/**
 * 比较实现Comparable的数组。
 */
public class SelectionSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        // 选择n-1个，剩下的为最大的。
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    public static void swap(Object[] arr, int minIndex, int i) {
        Object tmp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = tmp;
    }

    public static <T extends Comparable<T>>boolean checkOrder(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        sort(a);
        System.out.println(checkOrder(a));
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

        Double[] b = { 4.4, 3.3, 2.2, 1.1 };
        sort(b);
        System.out.println(checkOrder(b));

        String[] c = { "D", "C", "B", "A" };
        sort(c);
        System.out.println(checkOrder(c));

        Student[] d = new Student[4];
        d[0] = new Student("D", 90);
        d[1] = new Student("C", 100);
        d[2] = new Student("B", 95);
        d[3] = new Student("A", 95);
        sort(d);
        System.out.println(checkOrder(d));
        for(int i = 0 ; i < d.length; i++){
            System.out.println(d[i]);
        }

    }

}
