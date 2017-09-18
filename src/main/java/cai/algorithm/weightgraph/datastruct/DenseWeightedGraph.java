package cai.algorithm.weightgraph.datastruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph{
    private final static Logger logger = LoggerFactory.getLogger(DenseWeightedGraph.class);
    private int n;
    private int m ;
    private boolean directed;
    private Edge<Weight>[][] g;
    
    public DenseWeightedGraph(int n,boolean directed){
        if(n<=0){
            logger.error("接单数为"+n+"错误");
        }
        this.n = n;
        g = new Edge[n][n];
        this.directed = directed;
        this.m = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                g[i][j] = null;
            }
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        int a = e.v();
        int b = e.w();
        if(hasEdge(a,b)){
            return;
        }
        g[a][b]= new Edge(e);
        if(a!=b && !directed){
            g[b][a] = new Edge(b,a,e.wt());
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if(v<0||w<0||v>=n||w>=n){
            logger.error("节点越界！！！");
        }
        return g[v][w]!= null;
    }

    @Override
    public void show() {
        System.out.print("  ");
        for(int i = 0; i< n; i++){
            System.out.print(" "+i+" \t");
        }
        System.out.println();
        for(int i = 0; i< n; i++){
            System.out.print(i+" ");
            for(int j = 0; j < n; j++){
                if(g[i][j] != null){
                    System.out.print(g[i][j].wt()+"\t");
                }else{
                    System.out.print("null\t");
                }
                
            }
            System.out.println();
        }
    }

    public void print(){
        System.out.print("  ");
        for(int i = 0; i< n; i++){
            System.out.print(i+"  ");
        }
        for(int i = 0; i< n; i++){
            System.out.print(i+"  ");
            for(int j = 0; j < n; j++){
                if(g[i][j]==null){
                    System.out.print("  ");
                    
                }else{
                    System.out.print(g[i][j].wt()+"  ");
                }
            }
            System.out.println();
        }
    }
    @Override
    public Iterator adjE(int v) {
        if(v< 0 || v>=n){
            logger.error("节点越界！！！");
        }
        ArrayList<Edge<Weight>> adE = new ArrayList();
        for(int i = 0; i < n; i++){
            if(g[v][i]!=null){
                adE.add(g[v][i]);
            }
        }
        return adE.iterator();
    }
    

}
