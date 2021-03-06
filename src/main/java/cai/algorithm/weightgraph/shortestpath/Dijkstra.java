package cai.algorithm.weightgraph.shortestpath;

import java.util.Iterator;
import java.util.LinkedList;

import cai.algorithm.weightgraph.datastruct.Edge;
import cai.algorithm.weightgraph.datastruct.ReadWeightGraph;
import cai.algorithm.weightgraph.datastruct.SparseWeightedGraph;
import cai.algorithm.weightgraph.datastruct.WeightedGraph;

/**
 * @author chzone 关键步骤：松弛操作，
 */
public class Dijkstra<Weight extends Number & Comparable> {
    private int s;
    /**
     * 标记是否访问
     */
    private boolean[] marked;
    /**
     * 保存最大路径连接的边
     */
    private Edge<Weight>[] from;
    private WeightedGraph<Weight> g;

    // 从s原点到各点的距离
    private Number[] distTo;

    @SuppressWarnings("unchecked")
    public Dijkstra(WeightedGraph<Weight> g, int s) {
        this.g = g;
        marked = new boolean[g.V()];
        from = new Edge[g.V()];
        distTo = new Number[g.V()];
        this.s = s;
        IndexMinHeap<Weight> imh = new IndexMinHeap<>(g.V());
        // 初始化
        for (int i = 0; i < g.V(); i++) {
            marked[i] = false;
            distTo[i] = 0;
            from[i] = null;
        }
        distTo[s] = 0.0;
        from[s] = new Edge<>(s, s, (Weight) (Number) (0.0));
        imh.insert(s, (Weight) distTo[s]);
        while (!imh.isEmpty()) {
            // v的最短路径确定了
            int fromVertice = imh.extractMin();
            marked[fromVertice] = true;
            Iterator<Edge<Weight>> it = g.adjE(fromVertice);
            while (it.hasNext()) {
                Edge<Weight> e = it.next();
                // 经过v的可达的节点
                int toVertice = e.other(fromVertice);
                if (!marked[toVertice]) {
                    if (from[toVertice] == null || distTo[fromVertice].doubleValue()
                            + e.wt().doubleValue() < distTo[toVertice].doubleValue()) {
                        distTo[toVertice] = distTo[fromVertice].doubleValue() + e.wt().doubleValue();
                        from[toVertice] = e;

                        if (imh.contains(toVertice)) {
                            imh.change(toVertice, (Weight) distTo[toVertice]);
                        } else {
                            imh.insert(toVertice, (Weight) distTo[toVertice]);
                        }
                    }

                }

            }

        }
    }

    public Number shortestPathWeight(int v) {
        return distTo[v];
    }

    public boolean hasPath(int v) {
        return marked[v];
    }

    public void showpath(int v) {
        if (!hasPath(v)) {
            System.out.println("No Path!!!");
            return;
        }

        LinkedList<Edge<Weight>> pathList = new LinkedList<>();

        Edge<Weight> e = from[v];
        while (e.v() != this.s) {
            // 把两个顶点最好写成 fromt to
            pathList.add(0, e);
            e = from[e.v()];
        }

        pathList.add(0, e);

        for (int i = 0; i < pathList.size(); i++) {
            System.out.print(pathList.get(i).v() + "->");
            if (i == pathList.size() - 1) {
                System.out.println(pathList.get(i).w());
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        String fileName = "graph/testG2_stp.txt";
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, true);
        ReadWeightGraph.read(g, fileName);
        Dijkstra<Double> djDijkstra = new Dijkstra<>(g, 0);
        for (int i = 0; i < g.V(); i++) {
            System.out.println("path:0 to " + i + " weight:" + djDijkstra.shortestPathWeight(i));
            djDijkstra.showpath(i);
            ;
        }
    }
}
