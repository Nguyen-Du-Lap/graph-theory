package baithuchanh2.bai2andbai4;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Graph {
    int vertex;
    Map<Integer, Set<Integer>> adjList;
    public abstract void initMatrixFromFile(String path) throws IOException;
    public abstract void printAdjList();
    public abstract int[][] getMatrix();
    public abstract void printMatrix();
    public abstract boolean isSimpleGraph();
    public abstract void bfs(int v);
    public abstract void dfs(int v);
    public abstract boolean isConnect();
    public abstract boolean isPath(int x, int y);
    public abstract int countConnect();
    public abstract List<Integer> euler(int a);
}
