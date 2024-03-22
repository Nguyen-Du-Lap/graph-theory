package baithuchanh2.bai2andbai4;

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
        System.out.println("Ma tran ke co huong:");
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
        return false;
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
        Map<Integer, Set<Integer>> list = handleCopyMap(adjList);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> isConnect = new ArrayList<>();
        boolean[] visited = new boolean[vertex];
        queue.add(0);
        visited[0] = true;
        isConnect.add(0);
        while(!queue.isEmpty()) {
            int nodeCurrent = queue.poll();
            Set<Integer> listNeighbor = list.get(nodeCurrent);
            for(int e : listNeighbor) {
                if(!visited[e]) {
                    queue.add(e);
                    isConnect.add(e);
                    visited[e] = true;
                }
            }
        }
        for(Map.Entry<Integer, Set<Integer>> entry: adjList.entrySet()) {
            if(entry.getValue().isEmpty()) System.out.println("Lien thong yeu");
        }
      return isConnect.size()==vertex;
    }

    private Map<Integer, Set<Integer>> handleCopyMap(Map<Integer, Set<Integer>> adjList) {
        Map<Integer, Set<Integer>> list = new HashMap<>(adjList);
        for(Map.Entry<Integer, Set<Integer>> entry : adjList.entrySet()) {
            int key = entry.getKey();
            for(int e : entry.getValue()) {
                if(!adjList.get(e).contains(key)) list.get(e).add(key);
            }
        }
        return list;
    }

    @Override
    public boolean isPath(int x, int y) {
        boolean[] visits = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visits[x] = true;
        while (!queue.isEmpty()) {
            int vCurrent = queue.poll();
            for(int e : adjList.get(vCurrent)) {
                if(!visits[e]) {
                    if(e==y) return true;
                    queue.add(e);
                    visits[e] = true;
                }
            }
        }
        return false;
    }

    @Override
    public int countConnect() {
        return 0;
    }

    @Override
    public List<Integer> euler(int a) {
        return null;
    }
}
