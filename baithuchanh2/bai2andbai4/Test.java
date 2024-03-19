package baithuchanh2.bai2andbai4;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Graph g1 = new UnDirectedGraph("baithuchanh2/bai2andbai4/H2.txt");
        g1.printAdjList();
        g1.printMatrix();
    }
}
