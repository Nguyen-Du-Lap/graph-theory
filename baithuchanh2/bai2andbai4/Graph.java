package baithuchanh2.bai2andbai4;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public abstract class Graph {
    int vertex;
    Map<Integer, Set<Integer>> adjList;
    public abstract void initMatrixFromFile(String path) throws IOException;
    public abstract void printAdjList();
    public abstract int[][] getMatrix();
    public abstract void printMatrix();
}