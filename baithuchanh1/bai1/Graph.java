package baithuchanh1.bai1;

public abstract class Graph {
    int vertex;
    int[][] adjMatrix;
    public Graph(int vertex) {
        this.vertex = vertex;
        this.adjMatrix = new int[vertex][vertex];
    }
    public abstract void addEdge(int i, int j);
    public abstract void removeEdge(int i, int j);
    public abstract int degree(int v);
    public abstract int edges();
    // danh sách kề
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
    // ma trận kề
    public void adjacencyMatrix(){
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    // danh sách cạnh
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
    public abstract void euler();
}
