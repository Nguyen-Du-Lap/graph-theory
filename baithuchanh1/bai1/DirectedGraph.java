package baithuchanh1.bai1;

import java.io.IOException;
import java.util.List;

public class DirectedGraph extends Graph {

    public DirectedGraph(int vertex) {
        super(vertex);
    }

    @Override
    public void addEdge(int i, int j) {
        this.adjMatrix[i][j]++;
    }

    @Override
    public void removeEdge(int i, int j) {
        if (this.adjMatrix[i][j] > 0) {
            this.adjMatrix[i][j]--;
        }
    }

    @Override
    public int degree(int v) {
        return 0;
    }

    @Override
    public int degreeIn(int v) {
        int sum = 0;
        for (int i = 0; i < vertex; i++) {
            sum += adjMatrix[i][v];
        }
        return sum;
    }

    @Override
    public int degreeOut(int v) {
        int sum = 0;
        for (int i = 0; i < vertex; i++) {
            sum += adjMatrix[v][i];
        }
        return sum;
    }

    @Override
    public int edges() {
        int sum = 0;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                sum += adjMatrix[i][j];
            }
        }
        return sum;
    }

    @Override
    public void edgeList() {
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if(adjMatrix[i][j] == 1) System.out.print("[" + i + "," + j + "] ");
            }
        }
    }

    @Override
    public boolean isConnectionBFS() {
        return false;
    }

    @Override
    public boolean isConnectionDFSRecursive() {
        return false;
    }

    @Override
    public boolean isConnectionDFSStack() {
        return false;
    }

    @Override
    public boolean isEuler() {
        return false;
    }

    @Override
    public boolean isHalfEuler() {
        return false;
    }

	@Override
	public List<Integer> euler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean haveEdge(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initMatrixFromFile(String path) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAdjList() {
		// TODO Auto-generated method stub
		
	}


}
