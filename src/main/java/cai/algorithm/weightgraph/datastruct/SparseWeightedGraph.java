package cai.algorithm.weightgraph.datastruct;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph<Weight>{
    private final static Logger logger = LoggerFactory.getLogger(SparseWeightedGraph.class);
    /**
     * 节点数
     */
    private int n;
    /**
     * 边数
     */
    private int m;
    /**
     * 是否有向图
     */
    private boolean directed;
    /**
     * 邻接表
     */
    private ArrayList<Edge<Weight>>[] g;// 漏掉[]
    
    public  SparseWeightedGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.m = 0;
        g = new ArrayList[n];
        for(int i = 0; i< n;i++){
            g[i] = new ArrayList<Edge<Weight>>();
        }
    }
    @Override
    public int V() {
        return this.n;
    }

    @Override
    public int E() {
        return this.m;
    }

    @Override
    public void addEdge(Edge<Weight> e) {
//        if(hasEdge(e.v(),e.w())){
//            return;
//        }
        // 课程给出的代码没有重复边判断，因此可以有重复边。
        g[e.v()].add(new Edge<Weight>(e.v(),e.w(),e.wt()));
        //无向图对角线出外，每次加两条边。
        if(e.v()!=e.w()&&!this.directed){
            g[e.w()].add(new Edge<Weight>(e.w(),e.v(),e.wt()));
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if(v<0||v>=n||w<0||w>=n){
            logger.error("节点越界");
        }
        for(int i = 0; i< g[v].size(); i++){
            if(g[v].get(i).other(v)==w){
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for(int i = 0; i< n; i++){
            System.out.print("vertex "+i+":\t");
            for(int j = 0; j < g[i].size();j++){
                Edge<Weight> e = g[i].get(j);
                System.out.print("to:"+e.other(i)+",wt:"+e.wt()+"\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<Edge<Weight>> adjE(int v) {
        return g[v].iterator();
    }
    

}
