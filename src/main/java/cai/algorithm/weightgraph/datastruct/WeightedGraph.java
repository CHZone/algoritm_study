package cai.algorithm.weightgraph.datastruct;

import java.util.Iterator;

public interface WeightedGraph<Weight extends Number & Comparable> {
    public int V();
    public int E();
    public void  addEdge(Edge<Weight> e);
    boolean hasEdge(int v,int w);
    void show();
    public Iterator<Edge<Weight>> adjE(int v);
}
