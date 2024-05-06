package baithuchanh1.bai1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UnDirectedGraph extends Graph {

    public UnDirectedGraph(int vertex) {
        super(vertex);
    }
    public UnDirectedGraph(String path) throws IOException {
    	super(path);
    }

    @Override
    public void addEdge(int i, int j) {
        this.adjMatrix[i][j]++;
        if (i != j) this.adjMatrix[j][i]++;
    }

    @Override
    public void removeEdge(int i, int j) {
        if(this.adjMatrix[i][j] > 0 && this.adjMatrix[j][i] > 0) {
            this.adjMatrix[i][j]--;
            this.adjMatrix[j][i]--;
        }
    }

    @Override
    public int degree(int v) {
        int s = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (i == v) s += adjMatrix[v][i] * 2;
            else s += adjMatrix[v][i];
        }
        return s;
    }

    @Override
    public int edges() {
        int edges = 0;
        for (int i = 0; i < vertex; i++) {
            edges += degree(i);
        }
        return edges / 2;
    }

    @Override
    public void edgeList() {
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = i; j < adjMatrix[i].length; j++) {
                for (int k = 0; k < adjMatrix[i][j]; k++) {
                    System.out.print("[" + i + "," + j + "] ");
                }
            }
        }
    }

    @Override
    public boolean isCheckerBipartite() {
        final int NONE_COLOR = 0;
        final int RED = 1;
        final int GREEN = 2;
        int[] vColors = new int[vertex];
        Queue<Integer> vQueue = new LinkedList<>();

        for (int i = 0; i < vColors.length; i++) {
            vColors[i] = NONE_COLOR;
        }

        vQueue.offer(0);
        vColors[0] = RED;
        // duyá»‡t qua cÃ¡c Ä‘á»‰nh trong Ä‘á»“ thá»‹,
        // trÃ¡nh trÆ°á»�ng há»£p Ä‘á»“ thá»‹ khÃ´ng liÃªn thÃ´ng khÃ´ng thá»ƒ xÃ©t háº¿t cÃ¡c Ä‘á»‰nh
        for (int i = 0; i < vertex; i++) {
            while (!vQueue.isEmpty()) {
                int vCurrent = vQueue.poll();
                int colorCurrent = vColors[vCurrent];
                int colorNext = colorCurrent == RED ? GREEN : RED;
                // duyá»‡t cá»§a tá»«ng Ä‘á»‰nh ká»� cá»§a vCurrent
                for (int j = 0; j < adjMatrix[vCurrent].length; j++) {
                    // kiá»ƒm tra Ä‘á»‰nh cÃ³ ká»� vá»›i Ä‘á»‰nh Ä‘ang xÃ©t
                    if (adjMatrix[vCurrent][j] == 1) {
                        // 2 Ä‘á»‰nh ká»� nhau cÃ¹ng mÃ u tráº£ vá»� false
                        if (vColors[j] == colorCurrent) return false;
                        // Ä‘á»‰nh chÆ°a xÃ©t má»›i bá»� vÃ o queue
                        if (vColors[j] == NONE_COLOR) {
                            vQueue.offer(j);
                            vColors[j] = colorNext;

                        }
                    }
                }

            }
        }
        return true;
    }

    @Override
    public boolean isConnectionBFS() {
        List<Integer> browseVertices = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visits = new boolean[vertex];
        int nodeFirst = 0;
        queue.add(nodeFirst);
        browseVertices.add(nodeFirst);
        visits[nodeFirst] = true;
        while (!queue.isEmpty()) {
            int nodeCurrent = queue.poll();
            for(int i = 0; i < vertex ; i++) {
                if(adjMatrix[nodeCurrent][i] > 0 && !visits[i]) {
                    queue.add(i);
                    browseVertices.add(i);
                    visits[i] = true;
                }
            }
        }
        if(browseVertices.size() == vertex) return true;
        return false;
    }
    @Override
    public boolean isConnectionDFSRecursive() {
        List<Integer> browseVertices = new LinkedList<>();
        boolean[] visits = new boolean[vertex];
        int nodeFirst = 0;
        recursive(browseVertices, visits, nodeFirst);
        if(browseVertices.size() == vertex) return true;
        return false;
    }

    private void recursive(List<Integer> browseVertices, boolean[] visits, int node) {
        browseVertices.add(node);
        visits[node] = true;
        for(int i = 0; i < vertex; i++) {
            if(adjMatrix[node][i] > 0 && !visits[i]){
                recursive(browseVertices, visits, i);
            }
        }
    }

    @Override
    public boolean isConnectionDFSStack() {
        List<Integer> browseVertices = new LinkedList<>();
        boolean[] visits = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        int nodeFirst = 0;
        stack.push(nodeFirst);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visits[node]) {
                browseVertices.add(node);
                visits[node] = true;
                for (int i = vertex - 1; i >= 0; i--) {
                    if (adjMatrix[node][i] > 0 && !visits[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        if (browseVertices.size() == vertex) return true;
        return false;
    }

    @Override
    public boolean isEuler() {
        if(!isConnectionBFS()) return false;
        for(int i = 0; i < vertex; i++) {
            if(degree(i) % 2 != 0) return false;
        }
        return true;
    }

    @Override
    public boolean isHalfEuler() {
        int countOdd = 0;
        if(!isConnectionBFS()) return false;
        for(int i = 0; i < vertex; i++) {
            if(degree(i) % 2 != 0) countOdd++;
        }
        return countOdd == 2 || countOdd == 0;
    }

	@Override
	public List<Integer> euler() {
		List<Integer> C = new ArrayList<Integer>();
		if(!isEuler()) return null;
		Graph H = this.copy();
		int a = 0;
		int m = H.edges();
		C.add(a);
		while(m>0) {
			int v = 0;
			for(int i=0; i < C.size(); i++) {
				if(H.degree(i) > 0) {
					v = i;
					break;
				}
			}
			List<Integer> sub = new ArrayList<Integer>();
			int i = v;
			while(H.degree(i) > 0) {
				sub.add(i);
				for(int j=0; j<vertex;j++) {
					if(H.haveEdge(i, j)) {
						H.removeEdge(i, j);
						i=j;
						m--;
						break;
					}
				}
			}
//			sub.add(v);
			C.addAll(v, sub);
		}
		return C;
	}
	@Override
	public boolean haveEdge(int i, int j) {
		for(int k=0; k<vertex;k++) {
			for(int l=0; l < vertex; l++) {
				if(adjMatrix[i][j] > 0) return true;
			}
		}
		return false;
	}
	private Graph copy() {
		Graph tmp= new UnDirectedGraph(this.adjMatrix.length);
		for(int i=0;i<vertex;i++) {
			for(int j=i; j<vertex;j++) {
				if(adjMatrix[i][j] > 0) {
                    for(int k=0; k<adjMatrix[i][j]; k++) {
                        tmp.addEdge(i, j);
                    }
				}
			}
		}
		return tmp;
	}
	
	@Override
    public void initMatrixFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        this.vertex = Integer.parseInt(reader.readLine());
        adjMatrix = new int[vertex][vertex];

        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < vertex; i++) {
                this.adjMatrix[row][i] = Integer.parseInt(st.nextToken());
            }
            row++;
        }
        reader.close();
    }

    @Override
    public boolean isTree() {
        if(!isConnectionBFS()) return false;
        if(edges() != vertex-1) return false;
        return true;
    }

    @Override
	public void printAdjList() {
		System.out.println("Ma tran ke vo huong:");
        for (int i = 0; i < vertex; i++) {
            for(int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j]+" " );
            }
            System.out.println();
        }
		
	}
	



}
