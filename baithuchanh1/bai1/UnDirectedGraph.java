package baithuchanh1.bai1;

import java.util.*;

public class UnDirectedGraph extends Graph {

    public UnDirectedGraph(int vertex) {
        super(vertex);
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
        // duyệt qua các đỉnh trong đồ thị,
        // tránh trường hợp đồ thị không liên thông không thể xét hết các đỉnh
        for (int i = 0; i < vertex; i++) {
            while (!vQueue.isEmpty()) {
                int vCurrent = vQueue.poll();
                int colorCurrent = vColors[vCurrent];
                int colorNext = colorCurrent == RED ? GREEN : RED;
                // duyệt của từng đỉnh kề của vCurrent
                for (int j = 0; j < adjMatrix[vCurrent].length; j++) {
                    // kiểm tra đỉnh có kề với đỉnh đang xét
                    if (adjMatrix[vCurrent][j] == 1) {
                        // 2 đỉnh kề nhau cùng màu trả về false
                        if (vColors[j] == colorCurrent) return false;
                        // đỉnh chưa xét mới bỏ vào queue
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
        return countOdd == 2 && countOdd == 0;
    }

    @Override
    public void euler() {
        if(!isEuler()) return;
        List<Integer> C = new LinkedList<>();
        Random random = new Random();
        int a = random.nextInt(vertex);
        C.add(a);
        int[][] H = new int[vertex][vertex];
        for (int i = 0; i < H.length; i++) {
            for (int j = 0; j < H[i].length; j++) {
                H[i][j] = adjMatrix[i][j];
            }
        }
        int edges = edgesH(H, vertex);
        boolean[] isolation = new boolean[vertex];
        while (edges > 0) {
            int v = -1;
            boolean foundV = false;
            for (int i = 0; i < H.length && !foundV; i++) {
                if (C.contains(i)) {
                    v = i;
                    foundV = true;
                }
            }

        }
    }
    public int degreeH(int v, int[][] H) {
        int s = 0;
        for (int i = 0; i < H.length; i++) {
            if (i == v) s += H[v][i] * 2;
            else s += H[v][i];
        }
        return s;
    }

    public int edgesH(int[][] H, int vertexCount) {
        int edges = 0;
        for (int i = 0; i < vertexCount; i++) {
            edges += degreeH(i, H);
        }
        return edges / 2;
    }


}
