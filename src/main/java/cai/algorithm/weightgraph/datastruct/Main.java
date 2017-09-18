package cai.algorithm.weightgraph.datastruct;

public class Main {
    public static void main(String[] args){
        String fileName = "graph/testG1w.txt";
        SparseWeightedGraph<Double> swg = new SparseWeightedGraph<>(8, false);
        ReadWeightGraph.read(swg, fileName);
        System.out.println("Test G1W in Sparse Weighted Graph:");
        swg.show();
        
        System.out.println();
        
        DenseWeightedGraph<Double> dwg =new DenseWeightedGraph<>(8, false);
        ReadWeightGraph.read(dwg, fileName);
        System.out.println("Test G1W in Dense Weight Graph:");
        dwg.show();
    }
}
