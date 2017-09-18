package cai.algorithm.weightgraph.MST;

import java.util.ArrayList;
import java.util.Iterator;

import cai.algorithm.weightgraph.datastruct.Edge;
import cai.algorithm.weightgraph.datastruct.ReadWeightGraph;
import cai.algorithm.weightgraph.datastruct.SparseWeightedGraph;
import cai.algorithm.weightgraph.datastruct.WeightedGraph;

public class LazyPrimMST<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> g;
    private MinHeap<Edge<Weight>> mh;
    /**
     * 标记节点是否被访问过
     */
    private boolean[] marked;
    /**
     * 最小生成树对应的边
     */
    private ArrayList<Edge<Weight>> mst;
    /**
     * 最小生成树的总权重
     */
    private Number mstWeight;

    /**
     * 循环不变式： 1. 获取堆顶最小边 2. 将没有访问过的节点标记为访问。如果最小边的节点都已访问，continue 3. 邻边加入堆中 4.
     * 将该点标记为已访问
     * 
     * @param graph
     */
    public LazyPrimMST(WeightedGraph<Weight> graph) {
        g = graph;
        mh = new MinHeap<Edge<Weight>>(g.E());
        marked = new boolean[g.V()];// 没有初始化
        mst = new ArrayList<Edge<Weight>>();

        // lazy prim 每次取最小边，且有一个节点没有访问。加入到最小生成树中
        visit(0);
        while (!mh.isEmpty()) {
            Edge<Weight> e = mh.extractMin();
            if (marked[e.v()] == marked[e.w()]) { // 两边都访问了，或两边都没访问（不可能）
                continue;
            }
            // System.out.println(e);
            // 无向图边的节点无先后顺序。
            // 但会在 a[i][j]和a[j][i]
            // g[i] 和g[j]都添加
            mst.add(e);
            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }

        mstWeight = mst.get(0).wt();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.get(i).wt().doubleValue();
        }
    }

    public void visit(int i) {
        marked[i] = true;
        Iterator<Edge<Weight>> it = g.adjE(i);
        while (it.hasNext()) {
            Edge<Weight> e = it.next();
            if (!marked[e.other(i)]) {// 将没有访问的点的邻边添加到最小堆中
                mh.insert(e);
            }
        }
    }

    ArrayList<Edge<Weight>> mstEdges() {
        return mst;
    }

    Number result() {
        return mstWeight;
    }

    public ArrayList<Edge<Weight>> getMst() {
        return mst;
    }

    public Number getMstWeight() {
        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 8;
        String fileName = "graph/testG1_WPMST.txt";
        System.out.println("The lazy Prim:");
        SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<>(V, false);
        ReadWeightGraph.read(g2, fileName);
        LazyPrimMST<Double> lazyPrim = new LazyPrimMST<>(g2);
        ArrayList<Edge<Double>> mstList = lazyPrim.getMst();
        System.out.println("The lazy Prim:");
        for (int i = 0; i < mstList.size(); i++) {
            System.out.println(mstList.get(i));
        }
        System.out.println("The MST weight is" + lazyPrim.getMstWeight());
    }

    public void print() {
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
    }
}
