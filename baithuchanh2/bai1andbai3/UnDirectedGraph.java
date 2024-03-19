package baithuchanh2.bai1andbai3;

import java.io.*;
import java.util.*;

public class UnDirectedGraph extends Graph{
    public UnDirectedGraph(String path) throws IOException {
        initMatrixFromFile(path);
    }
    @Override
    public void initMatrixFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        this.vertex = Integer.parseInt(reader.readLine());
        adjMatrix = new int[vertex][vertex];

        String line;
        int row = 0;
        while((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            for(int i = 0; i < vertex; i++) {
                this.adjMatrix[row][i] = Integer.parseInt(st.nextToken());
            }
            row++;
        }
        reader.close();
    }

    @Override
    public void printMatrix() {
        System.out.println("Ma tran ke vo huong:");
        for (int i = 0; i < vertex; i++) {
            for(int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j]+" " );
            }
            System.out.println();
        }
    }

    @Override
    public void printListEdges() {
        System.out.println("Danh sach canh vo huong:");
        for (int i = 0; i < vertex; i++) {
            for(int j = i; j < vertex; j++) {
                int v = adjMatrix[i][j];
                if(v>0) {
                    for(int k = 0; k < v; k++) {
                        System.out.printf("(%d, %d), ", i,j);
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
            for(int j = 0; j < vertex; j++) {
                if(adjMatrix[i][j]>0) set.add(j);
            }
            map.put(i, set);
        }
        return map;
    }

    @Override
    public void printAdjList() {
        for(Map.Entry<Integer, Set<Integer>> entry: getAdjList().entrySet()) {
            System.out.println(entry.getKey() + "| " + entry.getValue());
        }
    }

    @Override
    public boolean isSimpleGraph() {
        for (int i = 0; i < vertex; i++) {
            if(adjMatrix[i][i] != 0) return false;
        }
        for (int i = 0; i < vertex; i++) {
            for(int j = 0; j < vertex; j++) {
                if(adjMatrix[i][i] > 1) return false;
            }
        }
        return true;
    }
    @Override
    public void bfs(int v) {
//        boolean[] visits = new boolean[vertex];
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(v);
//        visits[v] = true;
//        System.out.print(v+" ");
//        while (!queue.isEmpty()) {
//            int vCurrent = queue.poll();
//            for(int i = 0; i < vertex; i++) {
//                int vNeighbor = adjMatrix[vCurrent][i];
//                if(vNeighbor > 0 && !visits[i]) {
//                    queue.add(vNeighbor);
//                    visits[vNeighbor] = true;
//                    System.out.print(v+" ");
//                }
//            }
//        }
    }

}
