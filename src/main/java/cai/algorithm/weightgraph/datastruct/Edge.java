package cai.algorithm.weightgraph.datastruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Edge<Weight extends Number & Comparable> implements Comparable<Edge<Weight>> {
    private final static Logger logger = LoggerFactory.getLogger(Edge.class);
    private int a, b;//
    /**
     * 权值
     */
    private Weight weight;//

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    public int v() {
        return this.a;
    }

    public int w() {
        return this.b;
    }

    public Weight wt() {
        return weight;
    }

    public int other(int x) {
        if (x != a && x != b) {
            logger.error(x + "不是这条边的端点");
        }
        return x == a ? b : a;
    }

    @Override
    public int compareTo(Edge o) {
        if (weight.compareTo(o.weight) < 0) {
            return -1;
        } else if (weight.compareTo(o.weight) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "" + a + "-" + b + ":" + weight;
    }

}
