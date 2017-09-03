package cai.algorithm.union_find.data_struct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class UnionFindCompress {
    private final Logger logger = LoggerFactory.getLogger(UnionFindCompress.class);
    private Integer[] parent;
    private int[] rank;

    private Integer[] x;

    public UnionFindCompress(int n) {
        parent = new Integer[n];
        rank = new int[n];
        x = new Integer[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            x[i] = i;
        }
    }
    
    /**
     *  没有修改rank
     */
    private int find(int i){
        while(parent[i] != i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    
    public boolean isConnected(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);
        return rootI == rootJ;
    }
    
    public void union(int i , int j){
        int rootI = find(i);
        int rootJ = find(j);
        if(rootI == rootJ){
            return;
        }
        
        if(rank[rootI] < rank[rootJ]){
            parent[rootI] = rootJ;
        }else if(rank[rootI] > rank[rootJ]){
            parent[rootJ] = rootI;
        }else{
            parent[rootI] = rootJ;
            rank[rootJ] += 1;
        }
    }
    
    public static void main(String[] args){
        UnionFindCompress ufc = new UnionFindCompress(10);
        SortTestHelper.printArray(ufc.x);
        SortTestHelper.printArray(ufc.parent);
        ufc.union(1, 2);
        ufc.union(5, 6);
        ufc.union(7, 5);
        ufc.union(5, 1);
        SortTestHelper.printArray(ufc.parent);
    }
    
}
