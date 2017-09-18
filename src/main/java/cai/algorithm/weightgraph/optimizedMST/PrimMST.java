package cai.algorithm.weightgraph.optimizedMST;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.LayoutStyle;

import cai.algorithm.weightgraph.MST.LazyPrimMST;
import cai.algorithm.weightgraph.datastruct.Edge;
import cai.algorithm.weightgraph.datastruct.ReadWeightGraph;
import cai.algorithm.weightgraph.datastruct.SparseWeightedGraph;
import cai.algorithm.weightgraph.datastruct.WeightedGraph;

/**
 * @author chzone 以后想这样的复杂算法一定要 按照测试驱动开发的方式进行。 否则在调试上将单位很长时间 有时为了思路
 *         连贯可以先写整体，然后逐一测试，不要直接用，先单元测试，然后集成测试。
 * @param <Weight>
 */
public class PrimMST<Weight extends Number & Comparable> {
    private WeightedGraph g;
    private IndexMinHeap<Edge<Weight>> imh;
    private Edge<Weight>[] edgeTo;// 保存点对于的边，imh中保存的是最小边。
    private boolean[] marked;
    private ArrayList<Edge<Weight>> mst;
    private Number mstWeight;

    public PrimMST(WeightedGraph graph) {
        g = graph;
        imh = new IndexMinHeap<>(g.V());
        marked = new boolean[g.V()];
        mst = new ArrayList();
        mstWeight = 0;
        edgeTo = new Edge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            marked[i] = false;
            edgeTo[i] = null;
        }

        visit(0);
        while (!imh.isEmpty()) {
            // 该步已经包括了将已经访问过的边的编号从indexes中去除，所以，不必判断e是否已经访问
            // 且此处返回的e只是边的编号,不是边本身。
            int e = imh.extractMin();
            // 有一边没有访问。
            mst.add(edgeTo[e]);
            visit(e);
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
            int w = e.other(i);
            if (marked[w]) {
                continue;
            }
            if (edgeTo[w] == null) {
                edgeTo[w] = e;
                imh.insert(w, e);
            } else if (edgeTo[w].compareTo(e) > 0) {
                imh.change(w, e);
                edgeTo[w] = e;// 忘记根系edgeTo
            }
        }

    }

    public ArrayList<Edge<Weight>> mstEdges() {
        return mst;
    }

    public Number result() {
        return mstWeight;
    }

    public static void main(String[] args) {
        String fileName = "graph/testG1_WPMST.txt";
        int V = 8;
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadWeightGraph.read(g, fileName);
        System.out.println("Test Prim MST");
        PrimMST<Double> primMST = new PrimMST<>(g);
        ArrayList<Edge<Double>> mst = primMST.mstEdges();
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
        System.out.println("The MST weight is:" + primMST.result());
        System.out.println();

        System.out.println("The lazy Prim:");
        SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<>(V, false);
        ReadWeightGraph.read(g2, fileName);
        LazyPrimMST<Double> lazyPrim = new LazyPrimMST<>(g2);
        ArrayList<Edge<Double>> mstList = lazyPrim.getMst();
        for (int i = 0; i < mstList.size(); i++) {
            System.out.println(mstList.get(i));
        }
        System.out.println("The MST weight is" + lazyPrim.getMstWeight());
    }

    public ArrayList<Edge<Weight>> getMst() {
        return mst;
    }

    public Number getMstWeight() {
        return mstWeight;
    }

    public void print() {
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i));
        }
    }
}
