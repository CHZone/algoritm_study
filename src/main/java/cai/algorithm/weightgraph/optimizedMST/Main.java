package cai.algorithm.weightgraph.optimizedMST;

import cai.algorithm.weightgraph.MST.LazyPrimMST;
import cai.algorithm.weightgraph.datastruct.ReadWeightGraph;
import cai.algorithm.weightgraph.datastruct.SparseWeightedGraph;

public class Main {
    public static void main(String[] args) {
        String fileName1 = "graph/testG1_WPMST.txt";
        int V1 = 8;
        
        String fileName2 = "graph/testG2_WPMST.txt";
        int V2 = 250;
        
        String fileName3 = "graph/testG3_WPMST.txt";
        int V3 = 1000;
        
        String fileName4 = "graph/testG4_WPMST.txt";
        int V4 = 10000;
        
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(V1, false);
        ReadWeightGraph.read(g1, fileName1);
        SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<>(V2, false);
        ReadWeightGraph.read(g2, fileName2);
        SparseWeightedGraph<Double> g3 = new SparseWeightedGraph<>(V3, false);
        ReadWeightGraph.read(g3, fileName3);
        SparseWeightedGraph<Double> g4 = new SparseWeightedGraph<>(V4, false);
        ReadWeightGraph.read(g4, fileName4);
        
        long startTime,endTime;
        
        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST1 = new LazyPrimMST<>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Lazy Prim MST for G1("+V1+"):"+(endTime-startTime)+" ms. MST="+lazyPrimMST1.getMstWeight());
        startTime = System.currentTimeMillis();
        PrimMST<Double> PrimMST1 = new PrimMST<>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Prim MST for G1("+V1+"):"+(endTime-startTime)+" ms. MST="+PrimMST1.getMstWeight());
        
        
        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST2 = new LazyPrimMST<>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Lazy Prim MST for G2("+V2+"):"+(endTime-startTime)+" ms. MST="+lazyPrimMST2.getMstWeight());
        startTime = System.currentTimeMillis();
        PrimMST<Double> PrimMST2 = new PrimMST<>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Prim MST for G2("+V2+"):"+(endTime-startTime)+" ms. MST="+PrimMST2.getMstWeight());
        
        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST3 = new LazyPrimMST<>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Lazy Prim MST for G3("+V3+"):"+(endTime-startTime)+" ms. MST="+lazyPrimMST3.getMstWeight());
        startTime = System.currentTimeMillis();
        PrimMST<Double> PrimMST3 = new PrimMST<>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Prim MST for G3"+V3+"):"+(endTime-startTime)+" ms. MST="+PrimMST3.getMstWeight());
        
        
        startTime = System.currentTimeMillis();
        LazyPrimMST<Double> lazyPrimMST4 = new LazyPrimMST<>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Lazy Prim MST for G4("+V4+"):"+(endTime-startTime)+" ms. MST="+lazyPrimMST4.getMstWeight());
        startTime = System.currentTimeMillis();
        PrimMST<Double> PrimMST4 = new PrimMST<>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Prim MST for G4("+V4+"):"+(endTime-startTime)+" ms. MST="+PrimMST4.getMstWeight());
        
        
        
    }
}
