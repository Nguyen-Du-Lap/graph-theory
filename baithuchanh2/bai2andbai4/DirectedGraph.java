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
}
