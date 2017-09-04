package cai.algorithm.graph.DFS;

import cai.algorithm.graph.datastruct.DenseGraph;
import cai.algorithm.graph.datastruct.ReadGraph;
import cai.algorithm.graph.datastruct.SparseGraph;

public class Main {
    public static void main(String[] args){
        String fileName = "graph/testG1.txt";
        SparseGraph sg = new SparseGraph(13, false);
        ReadGraph.read(sg, fileName);
        Components components = new Components(sg);
        System.out.println("TestG1.txt, Component Count:"+components.count());
        System.out.println();
        
        DenseGraph dg = new DenseGraph(13, false);
        ReadGraph.read(dg, fileName);
        Components components2 = new Components(dg);
        System.out.println("TestG2.txt Dense Graph Component Count:"+components2.count());
        System.out.println();
        
        fileName = "graph/testG2.txt";
        SparseGraph sg2 = new SparseGraph(13, false);
        ReadGraph.read(sg2, fileName);
        Components components3 = new Components(sg2);
        System.out.println("TestG2.txt, Component Count:"+components3.count());
        System.out.println();
        
        DenseGraph dg2 = new DenseGraph(13, false);
        ReadGraph.read(dg2, fileName);
        Components components4 = new Components(dg2);
        System.out.println("TestG2.txt Dense Graph Component Count:"+components4.count());
        System.out.println();
        
        
        
    }
}
