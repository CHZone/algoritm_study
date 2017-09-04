package cai.algorithm.graph.path;

import cai.algorithm.graph.datastruct.DenseGraph;
import cai.algorithm.graph.datastruct.ReadGraph;
import cai.algorithm.graph.datastruct.SparseGraph;

public class Main {
    public static void main(String[] args) {
        String fileName = "graph/testG.txt";
        SparseGraph sg = new SparseGraph(7, false);
        ReadGraph.read(sg, fileName);
        sg.show();
        sg.print();
        System.out.println();
        FindPath fp = new FindPath(sg, 0);
        System.out.println("path from 0 to 6:");
        fp.showPath(6);
        
        fileName = "graph/testG.txt";
        DenseGraph dg = new DenseGraph(7, false);
        ReadGraph.read(dg, fileName);
        dg.show();
        dg.print();
        System.out.println();
        FindPath fp2 = new FindPath(dg, 0);
        System.out.println("path from 0 to 6:");
        fp2.showPath(6);
        
    }
}   
