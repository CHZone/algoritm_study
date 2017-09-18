package cai.algorithm.weightgraph.kruskal;

import java.util.ArrayList;
import java.util.Iterator;

import cai.algorithm.weightgraph.MST.LazyPrimMST;
import cai.algorithm.weightgraph.datastruct.Edge;
import cai.algorithm.weightgraph.datastruct.ReadWeightGraph;
import cai.algorithm.weightgraph.datastruct.SparseWeightedGraph;
import cai.algorithm.weightgraph.datastruct.WeightedGraph;
import cai.algorithm.weightgraph.optimizedMST.PrimMST;

public class KruskalMST<Weight extends Number & Comparable> {
    private ArrayList<Edge<Weight>> mst; 
    private Number mstWeight;
    
    public KruskalMST(WeightedGraph<Weight> g){
        UnionFindRank ufr = new UnionFindRank(g.V());
        mst = new ArrayList<>();
        MinHeap<Edge<Weight>> mh = new MinHeap<>(g.E());
        
        for(int i=0; i< g.V(); i++){
            Iterator<Edge<Weight>> it = g.adjE(i);
            while(it.hasNext()){
                Edge<Weight> e = it.next();
                if(e.v()<=e.w()){// 无像图可以理解，有向图呢？
                    mh.insert(e);
                }
            }
        }
        
        while(!mh.isEmpty()&&mst.size()<g.V()-1){
            Edge<Weight> e = mh.extractMin();
            if(ufr.isConnected(e.v(), e.w())){
                continue;
            }
            mst.add(e);
            ufr.union(e.v(), e.w());
        }
 
        mstWeight = mst.get(0).wt().doubleValue();
        for(int i = 1; i< mst.size();i++){
            mstWeight = mstWeight.doubleValue() + mst.get(i).wt().doubleValue();
        }
    }

    public Number getMstWeight() {
        return mstWeight;
    }
    
    public void print(){
        for(int i = 0; i<mst.size();i++){
            System.out.println(mst.get(i));
        }
    }
    
    public static void main(String[] args){
        String fileName = "graph/testG1_WPMST.txt";
        int V = 8;
        SparseWeightedGraph<Double> g = new SparseWeightedGraph<>(V, false);
        ReadWeightGraph.read(g, fileName);
        System.out.println("Test Kruskal:");
        KruskalMST<Double> kskMST = new KruskalMST<>(g);
        kskMST.print();
        System.out.println(kskMST.getMstWeight());
        
        System.out.println("Test lazy PRIM:");
        
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(g);
        lazyPrimMST.print();
        System.out.println(lazyPrimMST.getMstWeight());
        
        System.out.println("Test PRIM:");
        PrimMST<Double> primMST = new PrimMST<>(g);
        primMST.print();
        System.out.println(primMST.getMstWeight());
    }
}
