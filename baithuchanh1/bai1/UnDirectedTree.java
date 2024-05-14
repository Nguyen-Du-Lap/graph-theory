package baithuchanh1.bai1;

import java.io.IOException;
import java.util.*;

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
        Map<Integer, Integer> map = new HashMap<>();
        int[] visited = new int[vertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = 1;
        map.put(v, 0);
        while(!queue.isEmpty()) {
            int nodeCurrent = queue.poll();
            for(int i = 0; i < this.adjMatrix[nodeCurrent].length; i++) {
                if(this.adjMatrix[nodeCurrent][i] == 1 && visited[i] == 0) {
                    // get value node parent +1
                    for(int j = 0 ; j < this.vertex; j++) {
                        if(haveEdge(i,j) && visited[j] == 1) {
                            map.put(i, map.get(j)+1);
                        }
                    }

                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value > max) {
                max = value;
            }
        }
        return max;
    }

    public int radius() {
        int min = eccentricity(0);
        for(int i = 1; i < this.vertex; i++) {
            int e = eccentricity(i);
            if(e < min) {
                min = e;
            }
        }
        return min;
    }

    public List<Integer> centers() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < this.vertex; i++) {
            int e = eccentricity(i);
            List<Integer> list = map.containsKey(e) ? map.get(e) : new ArrayList<>();
            list.add(i);
            map.put(e, list);
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(entry.getKey() < min) {
                min = entry.getKey();
            }
        }
        return map.get(min);
    }

}
