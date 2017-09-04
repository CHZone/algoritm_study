package cai.algorithm.graph.datastruct;

import java.util.Iterator;

public interface Graph {
    public int V();
    public int E();
    public void addEdge(int v,int w);
    boolean hasEdge(int v,int w);
    void show();
    public Iterator<Integer> adjV(int v);
}
