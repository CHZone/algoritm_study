package cai.algorithm.union_find.data_struct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过id直接表示所属集合id
 * @author chzone
 */
public class UnionFind1 {
    private final Logger logger = LoggerFactory.getLogger(UnionFind1.class);
    private int[] id;
    private int count;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
        count = size;
    }

    private int find(int i) {
        if (i < 0 || i >= count) {
            logger.error("小标越界");
        }
        return id[i];
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }
    
    public void unionElement(int p,int q){
        int pid = find(p);
        int qid = find(q);
        if(pid==qid){//把qid 写成了 q
            return;
        }
        
        for(int i = 0; i < count; i++){
            if (id[i]==pid){
                id[i] = qid;
            }
        }
    }
    
    public static void main(String[] args) {
        UnionFind1 uf1 = new UnionFind1(10);
        uf1.unionElement(1, 2);
        uf1.unionElement(3, 2);
        uf1.unionElement(5, 2);
        for(int i = 0; i<uf1.id.length; i++){
            System.out.print(uf1.id[i]+",");
        }
    }

}
