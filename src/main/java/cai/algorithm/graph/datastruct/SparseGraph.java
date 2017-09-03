package cai.algorithm.graph.datastruct;

import java.util.ArrayList;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparseGraph {
    private final Logger logger = LoggerFactory.getLogger(SparseGraph.class);
    private int n;// 节点数
    private int m; // 边数
    private boolean directed; // 是否有向图
    private ArrayList[] g;

    public SparseGraph(int n, boolean directed) {
        if (n <= 0) {
            logger.error("图的节点数为：" + n);
        }
        g = new ArrayList[n];
        m= 0;
        this.directed = directed;
        this.n = n;
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int i, int j) {
        if(hasEdge(i,j)){
            return;
        }
        
        g[i].add(j);
        if( i!=j &&!directed){
            g[j].add(i);
        }
     
        m++;
    }

    public boolean hasEdge(int i, int j) {
        if(i<0 ||i>n|| j<0){
            logger.error("该图无法表示("+i+", "+j+")");
        }
        for (int k = 0; k < g[i].size(); k++) {
            if (g[i].get(k).equals(j)) {
                return true;
            }
        }
        return false;
    }
    
    public void print(){
        System.out.print("  ");
        for(int i = 0 ; i< n; i++){
            System.out.print("  "+i+"");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(" "+i+" ");
            for(int j = 0; j <n; j++){
                System.out.print(" "+(hasEdge(i, j)==true?"1":"∞")+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        SparseGraph sg = new SparseGraph(7, true);
        sg.addEdge(2, 3);
        sg.addEdge(5, 3);
        sg.addEdge(2, 4);
        sg.print();
    }
    
}
