package cai.algorithm.weightgraph.kruskal;

public class UnionFindRank {
    public int[] rank;
    public int[] parent;
    public int count;

    public UnionFindRank(int n) {
        count = n;
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        int groupi = find(i);
        int groupj = find(j);
        if (groupi == groupj) {
            return;
        }
        if (rank[groupi] > rank[groupj]) {
            parent[groupj] = groupi;
        } else if (rank[groupi] < rank[groupj]) {
            parent[groupi] = groupj;
        } else {
            parent[groupi] = groupj;
            rank[groupj]++;
        }
    }
}
