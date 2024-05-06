package baithuchanh1.bai1;

import java.io.IOException;
import java.util.List;

public abstract class Graph {
    int vertex;
    int[][] adjMatrix;
    public Graph(int vertex) {
        this.vertex = vertex;
        this.adjMatrix = new int[vertex][vertex];
    }
    public Graph(String path) throws IOException {
    	initMatrixFromFile(path);
    }
    public abstract void addEdge(int i, int j);
    public abstract void removeEdge(int i, int j);
    public abstract int degree(int v);
    public abstract int edges();
    // danh sÃ¡ch ká»�
    public void adjacencyList(){
        for (int i=0; i < vertex; i++) {
            System.out.print(i+"| ");
            for (int j=0; j < vertex; j++) {
                if(adjMatrix[i][j] > 0 && i != j) {
                    System.out.print(j +" ");
                }
            }
            System.out.println("");
        }
    }
    // ma tráº­n ká»�
    public void adjacencyMatrix(){
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public abstract void printAdjList();
    // danh sÃ¡ch cáº¡nh
    public abstract void edgeList();
    public boolean isCheckerBipartite(){
        return false;
    }

    public int degreeIn(int v) {
        return 0;
    }

    public int degreeOut(int v) {
        return 0;
    }
    public abstract boolean isConnectionBFS();
    public abstract boolean isConnectionDFSRecursive();
    public abstract boolean isConnectionDFSStack();
    public abstract boolean isEuler();
    public abstract boolean isHalfEuler();
    public abstract List<Integer> euler();
    public abstract  boolean haveEdge(int i, int j);
    public abstract void initMatrixFromFile(String path) throws IOException;
    public abstract boolean isTree();
}
