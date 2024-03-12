package baithuchanh1.bai2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Graph {
    protected int vertex;
    protected Map<Integer, ArrayList<Integer>> adjMap;
    protected List<List<Integer>> adjMatrix;
    public Graph(int vertex) {
        this.adjMap = new HashMap();
        adjMatrix = new ArrayList<>();
        this.vertex = vertex;
        for(int i = 0; i < vertex; i++) {
            adjMatrix.add(new ArrayList<Integer>());
        }
    }

    public List<List<Integer>> getAdjMatrix() {
        List<List<Integer>> listResult = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : this.adjMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            System.out.println(list);
            adjMatrix.add(list);
        }
        return listResult;
    }
    public void addEdge(int i, int j) {
        ArrayList<Integer> list = this.adjMap.get(i) == null ? new ArrayList<Integer>() : this.adjMap.get(i);
        list.add(j);
        this.adjMap.put(i, list);
    }
    public abstract void removeEdge(int i, int j);
    public abstract int degree(int v);
    public abstract int edges();
    // danh sách kề
    public void adjacencyList(){
        for(Map.Entry<Integer, ArrayList<Integer>> entry : this.adjMap.entrySet()) {
            int key = entry.getKey();
            ArrayList<Integer> list = entry.getValue();
            System.out.println(key+"| "+list);
        }
    }
    // ma trận kề
    public void adjacencyMatrix(){
        for(Map.Entry<Integer, ArrayList<Integer>> entry : this.adjMap.entrySet()) {
            int key = entry.getKey();
            ArrayList<Integer> list = entry.getValue();
            System.out.println(key+"| "+list);
        }
    }
    // danh sách cạnh
    public void edgeList() {
        for(Map.Entry<Integer, ArrayList<Integer>> entry : this.adjMap.entrySet()) {
            System.out.println(entry.getKey()+" | "+entry.getValue());
        }
    }
    public boolean isCheckerBipartite(){
        return false;
    }
    public int degreeIn(int v) {
        return 0;
    }
    public int degreeOut(int v) {
        return 0;
    }
}
