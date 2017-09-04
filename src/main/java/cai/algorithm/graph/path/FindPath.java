package cai.algorithm.graph.path;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cai.algorithm.graph.datastruct.Graph;

/**
 * @author chzone 深度优先寻路
 */
public class FindPath {
    private final Logger logger = LoggerFactory.getLogger(FindPath.class);
    private Graph G;
    /**
     * 寻路起点。
     */
    private int s;
    private boolean[] visited;
    private int[] from;// 访问带当前节点时的上一个节点

    public FindPath(Graph g, int s) {
        this.G = g;
        this.s = s;
        visited = new boolean[g.V()];
        from = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }

        dfs(s);
    }

    public void dfs(int i) {
        visited[i] = true;
        Iterator<Integer> it = G.adjV(i);
        while (it.hasNext()) {
            int v = it.next();
            if (!visited[v]) {
                from[v] = i;
                dfs(v);
            }
        }
    }

    public boolean hasPath(int w) {
        if (w < 0 || w >= G.V()) {
            logger.error("节点越界");
        }
        return visited[w];
    }

    public ArrayList<Integer> getPath(int w){
        if(!this.hasPath(w)){
            return null;
        }
        Stack<Integer> s = new Stack<>();
        s.push(w);
        int p = w;
        while(from[p]!=-1){
            s.push(from[p]);
            p = from[p];
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        while(!s.isEmpty()){
            path.add(s.pop());
        }
        return path;
    }
    
    public void showPath(int w){
        ArrayList<Integer> path = this.getPath(w);
        if(path!= null){
            for(int i = 0; i<path.size();i++){
                if(i<path.size()-1){
                    System.out.print(path.get(i)+"->");
                }else{
                    System.out.println(path.get(i));
                }
            }
        }
    }
}
