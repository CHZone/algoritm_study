package cai.algorithm.union_find.data_struct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class UnionFindSize {
    private final Logger logger = LoggerFactory.getLogger(UnionFindSize.class);
    public Integer[] parent;
    public int[] size;
    public int count;
    
    public Integer[] x;// 测试用于输出 下标

    public UnionFindSize(int n) {
        parent = new Integer[n];
        size = new int[n];
        count = n;
        
        x = new Integer[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            x[i] = i;
        }
    }

    private int find(int i) {
        if (i < 0 || i >= count) {
            logger.error("下标越界");
            return -1;
        }
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if (rooti == rootj) {
            return;
        }
        if (size[rooti] < size[rootj]) {
            parent[rooti] = rootj;
            size[rootj] = size[rooti] + size[rootj];
        } else {
            parent[rootj] = rooti;
            size[rooti] += size[rooti];
        }
    }
    
    public static void main(String[] args){
        UnionFindSize ufs = new UnionFindSize(10);
        SortTestHelper.printArray(ufs.x);
        SortTestHelper.printArray(ufs.parent);
        ufs.union(1, 2);
        ufs.union(5, 6);
        ufs.union(7, 5);
        ufs.union(5, 1);
        SortTestHelper.printArray(ufs.parent);
    }

}
