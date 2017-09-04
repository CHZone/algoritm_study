package cai.algorithm.graph.BFS;

import cai.algorithm.graph.datastruct.DenseGraph;
import cai.algorithm.graph.datastruct.ReadGraph;

public class Main {
    public static void main(String[] args){
        String fileName = "graph/testG.txt";
        DenseGraph dg = new DenseGraph(7, false);
        ReadGraph.read(dg, fileName);
        BFS bfs = new BFS(dg, 0);
        dg.show();
        dg.print();
        bfs.showPath(6);
    }
}
