package baithuchanh2.bai1andbai3;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public abstract class Graph {
    int vertex;
    int[][] adjMatrix;
    public abstract void initMatrixFromFile(String path) throws IOException;
    public abstract void printMatrix();
    public abstract void printListEdges();
    public abstract Map<Integer, Set<Integer>> getAdjList();
    public abstract void printAdjList();
    public abstract boolean isSimpleGraph();
    public abstract void bfs(int v);
    public abstract void dfs(int v);
    public abstract boolean isConnect();
    public abstract boolean isPath(int x, int y);
    public abstract int countConnect();
}
