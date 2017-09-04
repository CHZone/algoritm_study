package cai.algorithm.graph.DFS;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.graph.datastruct.Graph;

/**
 * @author chzone 求无权图的连通分量
 */
public class Components {
    private final Logger logger = LoggerFactory.getLogger(Components.class);
    Graph G;
    private boolean[] visited;// 记录节点是否已访问
    private int count;// 连通分量计数
    private int[] id;// 连通分量标记

    public Components(Graph g) {
        this.G = g;
        visited = new boolean[g.V()];
        count = 0;
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    public void dfs(int i) {
        id[i] = count;
        visited[i] = true;
        Iterator<Integer> it = G.adjV(i);
        while (it.hasNext()) {
            int v = it.next();
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    
    public int count(){
        return this.count;
    }
    boolean isConnected(int i, int j){
        if(i<0||j<0||i>=G.V()||j>=G.V()){
            logger.error("节点所用越界！！！");
        }
        return id[i]==id[j];
    }

}
