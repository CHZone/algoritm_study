package cai.algorithm.graph.datastruct;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparseGraph implements Graph {
    private final Logger logger = LoggerFactory.getLogger(SparseGraph.class);
    private int n;// 节点数
    private int m; // 边数
    private boolean directed; // 是否有向图
    private ArrayList<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        if (n <= 0) {
            logger.error("图的节点数为：" + n);
        }
        g = new ArrayList[n];
        m = 0;
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
        if (hasEdge(i, j)) {
            return;
        }

        g[i].add(j);
        // i,j不相等时的无向图，添加两条边。
        if (i != j && !directed) {
            g[j].add(i);
        }

        m++;
    }

    public boolean hasEdge(int i, int j) {
        if (i < 0 || i > n || j < 0) {
            logger.error("该图无法表示(" + i + ", " + j + ")");
        }
        for (int k = 0; k < g[i].size(); k++) {
            if (g[i].get(k).equals(j)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        if(this.n > 20){
            logger.error("节点数太多");
            return;
        }
        System.out.print("  ");
        for (int i = 0; i < n; i++) {
            System.out.print("  " + i + "");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + (hasEdge(i, j) == true ? "1" : "∞") + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < this.V(); i++) {
            System.out.print(i + ":");
            Iterator<Integer> it = this.adjV(i);
            while (it.hasNext()) {
                System.out.print(it.next() + ",");
            }
            System.out.println();
        }
    }

    public Iterator<Integer> adjV(int i) {
        if (i < 0 || i > n) {
            logger.error(i + "节点越界");
        }
        return g[i].iterator();
    }

    public static void main(String[] args) {
        SparseGraph sg = new SparseGraph(7, true);
        sg.addEdge(2, 3);
        sg.addEdge(5, 3);
        sg.addEdge(2, 4);
        sg.show();
    }

}
