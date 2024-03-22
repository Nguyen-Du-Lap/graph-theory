package baithuchanh2.bai2andbai4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UnDirectedGraph extends Graph {
    public UnDirectedGraph(String path) throws IOException {
        initMatrixFromFile(path);
    }

    @Override
    public void initMatrixFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        this.vertex = Integer.parseInt(reader.readLine());
        this.adjList = new HashMap<>();

        String line;
        int row = 0;

        while((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            Set<Integer> set = new TreeSet<>();
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                set.add(v);
            }
            adjList.put(row, set);
            row++;
        }
        reader.close();
    }

    @Override
    public void printAdjList() {
        for(Map.Entry<Integer, Set<Integer>> entry: adjList.entrySet()) {
            System.out.println(entry.getKey() + "| " + entry.getValue());
        }
    }

    @Override
    public int[][] getMatrix() {
        int[][] matrix = new int[vertex][vertex];
        for(Map.Entry<Integer, Set<Integer>> entry : adjList.entrySet()) {
            int key = entry.getKey();
            for(int v : entry.getValue()) {
                matrix[key][v] = 1;
            }
        }
        return matrix;
    }

    @Override
    public void printMatrix() {
        System.out.println("Ma tran ke vo huong:");
        int[][] matrix = getMatrix();
        for (int i = 0; i < vertex; i++) {
            for(int j = 0; j < vertex; j++) {
                System.out.print(matrix[i][j]+" " );
            }
            System.out.println();
        }
    }

    @Override
    public boolean isSimpleGraph() {
        return true;
    }

    @Override
    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex];
        queue.add(v);
        visited[v] = true;
        while(!queue.isEmpty()) {
            int nodeCurrent = queue.poll();
            System.out.print(nodeCurrent+" ");
            Set<Integer> listNeighbor = adjList.get(nodeCurrent);
            for(int e : listNeighbor) {
                if(!visited[e]) {
                    queue.add(e);
                    visited[e] = true;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertex];
        stack.add(v);
        while (!stack.isEmpty()) {
            int nodeCurrent = stack.pop();
            if(!visited[nodeCurrent]) {
                visited[nodeCurrent] = true;
                System.out.print(nodeCurrent+" ");
                Set<Integer> listNeighbor = adjList.get(nodeCurrent);
                stack.addAll(listNeighbor);
            }
        }
        System.out.println();
    }

    @Override
    public boolean isConnect() {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[vertex];
        int nodeFirst = 0;
        recursive(list, visited, nodeFirst);
        return list.size()==vertex;
    }
    public void recursive(List<Integer> list, boolean[] visited, int node) {
        if(!visited[node]) {
            visited[node] = true;
            list.add(node);
            for(int e : adjList.get(node)) {
                recursive(list, visited, e);
            }
        }

    }
    @Override
    public boolean isPath(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex];
        queue.add(x);
        visited[x] = true;
        while(!queue.isEmpty()) {
            int nodeCurrent = queue.poll();
            Set<Integer> listNeighbor = adjList.get(nodeCurrent);
            for(int e : listNeighbor) {
                if(!visited[e]) {
                    if(e == y) return true;
                    queue.add(e);
                    visited[e] = true;
                }
            }
        }
        return false;
    }

    @Override
    public int countConnect() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex];
        for(int i=0; i< vertex; i++) {
            if(!visited[i]) {
                count++;
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()) {
                    int nodeCurrent = queue.poll();
                    Set<Integer> listNeighbor = adjList.get(nodeCurrent);
                    for(int e : listNeighbor) {
                        if(!visited[e]) {
                            queue.add(e);
                            visited[e] = true;
                        }
                    }
                }
            }
        }

        return count;
    }
}
