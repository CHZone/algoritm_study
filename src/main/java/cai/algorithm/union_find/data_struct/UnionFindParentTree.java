package cai.algorithm.union_find.data_struct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnionFindParentTree {
    private final Logger logger = LoggerFactory.getLogger(UnionFindParentTree.class);
    private int [] id;
    private int count;
   
    public UnionFindParentTree(int size){
        id = new int[size];
        for(int i = 0; i < size; i++){
            id[i] = i;
        }
        count = size;
    }
    
    private int find(int i){
        if(i < 0 || i >= count){
            logger.error("下标越界！！！");
        }
        int parent = id[i];
        while(id[parent] != parent){
            parent = id[parent];
        }
        return parent;
    }
    
    public boolean isConnected(int p, int q){
        int pid = find(p);
        int qid = find(q);
        return pid == qid;
    }
    
    public void union(int p, int q){
        int pid = find(p);
        int qid = find(q);
        if(pid == qid){
            return;
        }
        id[pid] = qid;
    }
   
    public static void main(String[] args) {
        UnionFindParentTree ufpt = new UnionFindParentTree(10);
        ufpt.union(1, 2);
        ufpt.union(3, 2);
        ufpt.union(4, 5);
        ufpt.union(4, 2);
        ufpt.union(6, 5);
        
        for(int i = 0; i< ufpt.id.length; i++){
            System.out.print(ufpt.id[i]+",");
        }
        System.out.println();
        
    }
}
