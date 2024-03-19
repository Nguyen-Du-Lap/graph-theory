package baithuchanh2.bai1andbai3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DirectedGraph extends Graph {
    public DirectedGraph(String path) throws IOException {
        initMatrixFromFile(path);
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
    public void printMatrix() {
        System.out.println("Ma tran ke co huong:");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void printListEdges() {
        System.out.println("Danh sach canh co huong:");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                int v = adjMatrix[i][j];
                if (v > 0) {
                    for (int k = 0; k < v; k++) {
                        System.out.printf("(%d, %d), ", i, j);
                    }
                }
            }
        }
        System.out.println();
    }

    @Override
    public Map<Integer, Set<Integer>> getAdjList() {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            Set<Integer> set = new TreeSet<>();
            for (int j = 0; j < vertex; j++) {
                if (adjMatrix[i][j] > 0) set.add(j);
            }
            map.put(i, set);
        }
        return map;
    }

    @Override
    public void printAdjList() {
        for (Map.Entry<Integer, Set<Integer>> entry : getAdjList().entrySet()) {
            System.out.println(entry.getKey() + "| " + entry.getValue());
        }
    }

    @Override
    public boolean isSimpleGraph() {
        for (int i = 0; i < vertex; i++) {
            if (adjMatrix[i][i] != 0) return false;
        }
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                if (adjMatrix[i][i] > 1) return false;
            }
        }
        return true;
    }

    @Override
    public void bfs(int v) {
        boolean[] visits = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visits[v] = true;
        System.out.print(v + " ");
        while (!queue.isEmpty()) {
            int vCurrent = queue.poll();
            for (int i = 0; i < vertex; i++) {
                int vNeighbor = adjMatrix[vCurrent][i];
                if (vNeighbor > 0 && !visits[i]) {
                    queue.add(i);
                    visits[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(int v) {
        boolean[] visits = new boolean[vertex];
        recursive(visits, v);
        System.out.println();
    }

    private void recursive(boolean[] visits, int v) {
        System.out.print(v + " ");
        visits[v] = true;
        for (int i = 0; i < vertex; i++) {
            if (!visits[i] && adjMatrix[v][i] > 0) {
                recursive(visits, i);
            }
        }
    }

    @Override
    public boolean isConnect() {
        int[][] adjMatrixCopy = copyArrayAndHandle(adjMatrix);

        boolean[] visits = new boolean[vertex];
        int v = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> listConnect = new LinkedList<>();
        queue.add(v);
        visits[v] = true;
        listConnect.add(v);
        while (!queue.isEmpty()) {
            int vCurrent = queue.poll();
            for (int i = 0; i < vertex; i++) {
                int vNeighbor = adjMatrixCopy[vCurrent][i];
                if (vNeighbor > 0 && !visits[i]) {
                    queue.add(i);
                    visits[i] = true;
                    listConnect.add(i);
                }
            }
        }
        boolean isConnect = listConnect.size() == vertex;
        if(isConnect) {
            if(isCheckConnectStrong(adjMatrix)) System.out.println("Lien thong manh");
            else System.out.println("Lien thong yeu");
        }
        return isConnect;
    }
    public int[][] copyArrayAndHandle(int[][] arr) {
        int[][] result = new int[vertex][vertex];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(adjMatrix[i][j] > 0) {
                    result[i][j] = adjMatrix[i][j];
                    result[j][i] = adjMatrix[i][j];
                }
            }
        }
        return result;
    }
    public boolean isCheckConnectStrong(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(adjMatrix[i][j] > 0 && adjMatrix[j][i] == 0) return false;
                if(adjMatrix[i][j] == 0 && adjMatrix[j][i] > 0) return false;
            }
        }
        return true;
    }

    @Override
    public boolean isPath(int x, int y) {
        boolean[] visits = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visits[x] = true;
        while (!queue.isEmpty()) {
            int vCurrent = queue.poll();
            for (int i = 0; i < vertex; i++) {
                int vNeighbor = adjMatrix[vCurrent][i];
                if (vNeighbor > 0 && !visits[i]) {
                    queue.add(i);
                    visits[i] = true;
                    if (i == y) return true;
                }
            }
        }
        return false;
    }

    @Override
    public int countConnect() {
        int countConnect = 0;
        int[][] adjMatrixCopy = copyArrayAndHandle(adjMatrix);
        boolean[] visits = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> listConnect = new LinkedList<>();

        for (int j = 0; j < vertex; j++) {
            if (listConnect.size() != vertex && !visits[j]) {
                queue.add(j);
                visits[j] = true;
                listConnect.add(j);
                countConnect++;
                while (!queue.isEmpty()) {
                    int vCurrent = queue.poll();
                    for (int i = 0; i < vertex; i++) {
                        int vNeighbor = adjMatrixCopy[vCurrent][i];
                        if (vNeighbor > 0 && !visits[i]) {
                            queue.add(i);
                            visits[i] = true;
                            listConnect.add(i);
                        }
                    }
                }
            }
            if (listConnect.size() == vertex) return countConnect;
        }

        return countConnect;
    }
}
