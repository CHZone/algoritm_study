package cai.algorithm.union_find.data_struct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

/**
 * @author chzone
 * 通过rank压缩深度。
 * find为递归方法
 */
public class UnionFindCompressRecursive {
    private final Logger logger = LoggerFactory.getLogger(UnionFindCompressRecursive.class);
    private Integer[] parent;
    private int[] rank;
    private int count;
    private Integer[] x;
    
    public UnionFindCompressRecursive(int n){
        parent = new Integer[n];
        rank = new int[n];
        count = n;
        x = new Integer[n];
        for(int i = 0; i <  n; i++){
            parent[i] = i;
            rank[i] = 1;
            x[i] = i;
        }
    }
    
    /**
     * find 修改为递归
     */
    private int find(int i){
        if(i==parent[i]){
            return i;
        }else{
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    
    public boolean isConnected(int i , int j){
        int rootI = find(i);
        int rootJ = find(j);
        return rootI == rootJ;
    }
    
    public void union(int i, int j){
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
        UnionFindCompressRecursive  ufcr = new UnionFindCompressRecursive(10);
        SortTestHelper.printArray(ufcr.x);
        SortTestHelper.printArray(ufcr.parent);
        ufcr.union(1, 2);
        ufcr.union(5, 6);
        ufcr.union(7, 5);
        ufcr.union(5, 1);
        SortTestHelper.printArray(ufcr.parent);
    }
}
