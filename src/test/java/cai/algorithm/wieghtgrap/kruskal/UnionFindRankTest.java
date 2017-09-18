package cai.algorithm.wieghtgrap.kruskal;

import static org.junit.Assert.*;

import org.junit.Test;

import cai.algorithm.weightgraph.kruskal.UnionFindRank;

public class UnionFindRankTest {
    @Test
    public void testUnion(){
        UnionFindRank ufr = new UnionFindRank(10);
        ufr.union(1, 2);
        assertEquals(ufr.isConnected(1, 2),true);
        assertEquals(ufr.find(1), 2);
        ufr.union(3, 4);
        assertEquals(ufr.isConnected(3, 4),true);
        assertEquals(ufr.find(3), 4);
        ufr.union(0, 1);
        assertEquals(ufr.isConnected(0, 2), true);
        assertEquals(ufr.find(0), 2);
        ufr.union(0, 3);
        assertEquals(ufr.isConnected(0, 4), true);
        assertEquals(ufr.find(0), 4);
        
        assertEquals(ufr.isConnected(0, 5), false);
    }
}
