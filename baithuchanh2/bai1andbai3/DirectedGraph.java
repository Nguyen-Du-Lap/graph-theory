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
        System.out.println(vertex);
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
        System.out.println("Ma tran ke co huong:");
        for (int i = 0; i < vertex; i++) {
            for(int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j]+" " );
            }
            System.out.println();
        }
    }

    @Override
    public void printListEdges() {
        System.out.println("Danh sach canh co huong:");
        for (int i = 0; i < vertex; i++) {
            for(int j = 0; j < vertex; j++) {
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
        return false;
    }

    @Override
    public void bfs(int v) {

    }
}
