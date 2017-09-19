package cai.algorithm.weightgraph.shortestpath;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.naming.spi.DirStateFactory;

import cai.algorithm.weightgraph.datastruct.Edge;
import cai.algorithm.weightgraph.datastruct.WeightedGraph;

public class BellManFord<Weight extends Number & Comparable> {
    private Number[] weightTo;
    private int s;
    private WeightedGraph<Weight> g;
    private Edge<Weight>[] from;
    private boolean hasNegativeCycle;

    public BellManFord(WeightedGraph<Weight> g, int s) {
        this.s = s;
        weightTo = new Number[g.V()];
        this.g = g;
        from = new Edge[g.V()];
        for (int i = 0; i < g.V(); i++) {
            from[i] = null;
        }
        weightTo[s] = 0;
        from[s] = new Edge<>(s, s, (Weight) (Number) 0.0);
        // v-1次松弛操作
        for (int i = 0; i < g.V() - 1; i++) {
            // 遍历每个节点
            for (int j = 0; j < g.V(); j++) {
                Iterator<Edge<Weight>> it = g.adjE(j);
                // 对所有邻边进行松弛操作
                while (it.hasNext()) {
                    Edge<Weight> e = it.next();
                    int toVertice = e.other(j);
                    if (from[j] != null) {// j点可达
                        // toVertice第一次可达，会可以进行松弛操作
                        if (from[toVertice] == null || weightTo[toVertice].doubleValue() > weightTo[j].doubleValue()
                                + e.wt().doubleValue()) {
                            weightTo[toVertice] = weightTo[j].doubleValue() + e.wt().doubleValue();
                            from[e.other(j)] = e;
                        }
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCycle();
    }

    private boolean detectNegativeCycle() {
        for (int i = 0; i < g.V(); i++) {
            Iterator<Edge<Weight>> it = g.adjE(i);
            while (it.hasNext()) {
                Edge<Weight> e = it.next();
                int toVertice = e.other(i);
                if (weightTo[i] != null) {// i 可达
                    if (weightTo[toVertice] == null
                            || weightTo[toVertice].doubleValue() > weightTo[i].doubleValue() + e.wt().doubleValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean negativeCycle() {
        return hasNegativeCycle;
    }

    public Number shotestPathWeight(int i) {
        if (hasNegativeCycle) {
            throw new RuntimeException("有负权环，不存在最短路径");
        }
        return weightTo[i];
    }

    public boolean hasPathTo(int w) {
        return from[w] != null;
    }

    ArrayList<Edge<Weight>> shortestPath(int w) {
        if (!hasPathTo(w)) {
            return null;
        }
        Stack<Edge<Weight>> stack = new Stack<>();
        while (from[w].v() != s) {
            stack.push(from[w]);
            w = from[w].v();
        }
        stack.push(from[w]);
        ArrayList<Edge<Weight>> arr = new ArrayList<>();
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }
        return arr;
    }

    public void showPath(int w) {
        ArrayList<Edge<Weight>> path = shortestPath(w);
        if (path == null) {
            System.out.println("不可达");
            return;
        }
        int i = 0;
        for (; i < path.size(); i++) {
            System.out.print(path.get(i).v() + "->");
            if (i == path.size() - 1) {
                System.out.println(path.get(i).w());
            }
        }
    }

    public static void main(String[] args) {

    }
}
