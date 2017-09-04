package cai.algorithm.graph.datastruct;

import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args){
        String fileName = "graph/testG1.txt";
        SparseGraph sg = new SparseGraph(13, false);
        ReadGraph.read(sg, fileName);
        System.out.println("Test SparseGraph1 :");
        sg.show();
        System.out.println();
//        sg.print();
        DenseGraph dg = new DenseGraph(13, false);
        ReadGraph.read(dg, fileName);
        System.out.println("Test Dense Graph:");
        dg.show();
        System.out.println();
        
        fileName = "graph/testG2.txt";
        SparseGraph sg2 = new SparseGraph(6, false);
        ReadGraph.read(sg2, fileName);
        System.out.println("Test SparseGraph sg2:");
        sg2.show();
        System.out.println();
        
        DenseGraph dg2 = new DenseGraph(6, false);
        ReadGraph.read(dg2, fileName);
        System.out.println("Test dg2 in Dense Graph:");
        dg2.show();
        
        
    }
}
