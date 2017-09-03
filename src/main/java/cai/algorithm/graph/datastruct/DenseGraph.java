package cai.algorithm.graph.datastruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DenseGraph {
    private final Logger logger = LoggerFactory.getLogger(DenseGraph.class);
    private int n;// 节点数
    private int m; // 边数
    private boolean directed;// 是否是有向图
    private boolean[][] g; // 矩阵的连接表示
    
    public DenseGraph(int n, boolean directed){
        if(n <=0){
            logger.error("图的节点数为："+n);
        }
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }
    
    /**
     * 返回节点数
     */
    public int V(){
        return n;
    }
    /**
     *  返回边数
     */
    public int E(){
        return m ;
    }
    
    /**
     * 添加边
     */
    public void  addEdge(int i, int j){
        if(hasEdge(i,j)){
            return;
        }
        
        g[i][j] = true;
        if(!directed){
            g[j][i] = true;
        }
        m++;
    }
    
    public boolean hasEdge(int i, int j){
        if(i>=this.n || j>=this.n ||j <0 ||i <0){
            logger.error("边 ("+i+", "+j+") 非法！！！");
        }
        return g[i][j]==true;
    }
    
    public void print(){
        System.out.print("  ");
        for(int i = 0; i< n; i++){
            System.out.print(" "+i+" ");
        }
        System.out.println();
        for(int i = 0; i< n; i++){
            System.out.print(i+"  ");
            for(int j = 0; j < n; j++){
                System.out.print(""+(g[i][j]==false?"∞":"1")+"  ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        DenseGraph dg = new DenseGraph(7, true);
        dg.addEdge(1, 3);
        dg.addEdge(2,3);
        dg.addEdge(2, 5);
        dg.print();
    }
    
}
