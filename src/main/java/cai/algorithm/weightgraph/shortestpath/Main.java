package cai.algorithm.weightgraph.shortestpath;


import cai.algorithm.weightgraph.datastruct.ReadWeightGraph;
import cai.algorithm.weightgraph.datastruct.SparseWeightedGraph;

public class Main {
    public static void main(String[] args) {
        String fileName = "graph/testG2_stp.txt";
        int V = 5;
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(5, true);
        ReadWeightGraph.read(g,fileName);
        BellManFord<Double> bell = new BellManFord<>(g, 1);
        for(int i = 0; i<g.V();i++){
            System.out.println("Bell Main 0 to "+i+" Weight:"+bell.shotestPathWeight(i));
            bell.showPath(i);
        }
        
//        System.out.println("======================");
//        Dijkstra<Double> dj = new Dijkstra<>(g, 0);
//        
//        for(int i = 0; i<g.V();i++){
//            System.out.println("Dijkstra 0 to "+i+" Wieght:"+dj.shortestPathWeight(i));
//            dj.showpath(i);
//        }
    }
}
