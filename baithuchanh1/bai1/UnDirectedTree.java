package baithuchanh1.bai1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnDirectedTree extends  UnDirectedGraph{
    public int root;
    public boolean[] checkCycle;
    public UnDirectedTree(int vertex) {
        super(vertex);
        this.checkCycle = new boolean[vertex];
    }

    public UnDirectedTree(String path) throws IOException {
        super(path);
    }
    public void setRoot(int root) {
        this.root = root;
    }
    @Override
    public void addEdge(int i, int j) {
        if(checkCycle[i] && checkCycle[j]) return;

        this.adjMatrix[i][j]++;
        if (i != j) this.adjMatrix[j][i]++;
        checkCycle[i] = true;
        checkCycle[j] = true;
    }

    public boolean isEnough() {
        int n = countVertex();
        if(n != vertex) return false;
        if(edges() != n-1) return false;
        return true;
    }
    private int countVertex() {
        int result = 0;
        for(int i = 0; i < this.adjMatrix.length; i++) {
            for(int j = 0; j < this.adjMatrix[i].length; j++) {
                if(this.adjMatrix[i][j] == 1) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    public int eccentricity(int v) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[vertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = 1;
        list.add(v);
        while(!queue.isEmpty()) {
            int nodeCurrent = queue.poll();
            for(int i = 0; i < this.adjMatrix[nodeCurrent].length; i++) {
                if(this.adjMatrix[nodeCurrent][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        return max;
    }

}
