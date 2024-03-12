package baitaptrenlop;

import java.util.*;

public abstract class Graph {
    protected Map<Integer, Set<Integer>> adjMap;

    public Graph() {
        this.adjMap = new HashMap();
    }

    public abstract void addEdge(int i, int j);
    public abstract void print();
    public abstract void removeEdge(int i, int j);
    public abstract int degree(int v);
    public abstract int degreeIn(int v);
    public abstract int degreeOut(int v);
    public abstract int edges();
    // danh sách cạnh
    public abstract void edgeList();
    public boolean isCheckerBipartite(){
        return false;
    }

}
