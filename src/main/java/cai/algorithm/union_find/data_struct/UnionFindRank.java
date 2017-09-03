package cai.algorithm.union_find.data_struct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class UnionFindRank {
    private final Logger logger = LoggerFactory.getLogger(UnionFindRank.class);
    private Integer parent[];
    private int rank[];
    private int count;
    
    private Integer x[];

    public UnionFindRank(int n) {
        parent = new Integer[n];
        rank = new int[n];
        count = n;
        
        x = new Integer[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            x[i]=i;
        }
    }

    private int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        return rootI == rootJ;
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI == rootJ) {
            return;
        }
        if (rank[rootI] < rank[rootJ]) {
            parent[rootI] = rootJ;
        } else if (rank[rootI] > rank[rootJ]) {
            parent[rootJ] = rootI;
        } else {
            parent[rootI] = rootJ;
            rank[rootJ] += 1;
        }

    }

    public static void main(String[] args) {
        UnionFindRank ufr = new UnionFindRank(10);
        SortTestHelper.printArray(ufr.x);
        SortTestHelper.printArray(ufr.parent);
        ufr.union(1, 2);
        ufr.union(5, 6);
        ufr.union(7, 5);
        ufr.union(5, 1);
        SortTestHelper.printArray(ufr.parent);
    }

}
