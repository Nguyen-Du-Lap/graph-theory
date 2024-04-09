package baitaptrenlop;

import java.io.*;
import java.util.*;

public abstract class Graph {
    protected Map<Integer, Set<Integer>> adjMap;
    int vertex;
    public Graph() {
        this.adjMap = new HashMap();
    }
    public Graph(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        this.vertex = Integer.parseInt(reader.readLine());
        this.adjMap = new HashMap<>();

        String line;
        int row = 0;

        while((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            Set<Integer> set = new TreeSet<>();
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                set.add(v);
            }
            adjMap.put(row, set);
            row++;
        }
        reader.close();
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
