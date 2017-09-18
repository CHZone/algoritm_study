package cai.algorithm.weightgraph.MST;

import java.util.ArrayList;

import javax.swing.text.LayeredHighlighter;

import cai.algorithm.weightgraph.datastruct.Edge;
import cai.algorithm.weightgraph.datastruct.ReadWeightGraph;
import cai.algorithm.weightgraph.datastruct.SparseWeightedGraph;

public class Main {
    public static void main(String[] args){
        String fileName = "graph/testG1mst.txt";
        int V = 8;
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadWeightGraph.read(g, fileName);
        
        System.out.println("Test Lazy Prim MST:"+g.E());
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(g);
        ArrayList<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for(int i = 0; i< mst.size();i++){
            System.out.println(mst.get(i));
        }
        System.out.println("The MST weight is"+lazyPrimMST.result());
        System.out.println();
        
    }
}
