package cai.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.graph.datastruct.Graph;

/**
 * @author chzone 广度优先寻路
 */
public class BFS {
    private final Logger logger = LoggerFactory.getLogger(BFS.class);
    private Graph G;
    private boolean[] visited;
    private int[] from;
    /**
     * 层序遍历中对应的层
     */
    private int[] ord;//
    private int s;

    public BFS(Graph g, int s) {
        G = g;
        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;
        // 无向图最短路径算法，
        LinkedList<Integer> q = new LinkedList();
        q.push(s);
        ord[s] = 0;
        visited[s] = true;
        // 入队是修改访问标记
        while (!q.isEmpty()) {
            int v = q.pop();
            Iterator<Integer> it = G.adjV(v);
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    from[n] = v;
                    ord[n] = ord[v] + 1;
                    q.push(n);
                }
            }
        }
    }

    public boolean hasPath(int w) {
        if (w < 0 || w >= G.V()) {
            logger.error("节点越界");
        }
        return visited[w];
    }

    public ArrayList<Integer> getPath(int w) {
        if (!hasPath(w)) {
            return null;
        }
        Stack<Integer> s = new Stack();
        int p = w;
//        s.push(p);
        while (p != -1) {
            s.push(p);
            p = from[p];
        }
        
        ArrayList<Integer> path = new ArrayList();
        while(!s.isEmpty()){
            path.add(s.pop());
        }
        return path;
    }
    public void showPath(int w){
        ArrayList<Integer> path = getPath(w);
        if(path != null){
            for(int i = 0; i< path.size();i ++){
                if(i != path.size()-1){
                    System.out.print(path.get(i)+"->");
                }else{
                    System.out.println(path.get(i));
                }
            }
        }
    }
}
