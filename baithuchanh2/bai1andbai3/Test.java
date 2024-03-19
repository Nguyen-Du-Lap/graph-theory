package baithuchanh2.bai1andbai3;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Graph g1 = new UnDirectedGraph("baithuchanh2/bai1andbai3/H1.txt");
        g1.printMatrix();
        System.out.println(g1.isSimpleGraph());
//        g1.bfs(0);
//        Graph g2 = new DirectedGraph("baithuchanh2/bai1andbai3/G3.txt");
//        g2.printMatrix();
//        g2.printListEdges();
//        g2.printAdjList();
    }
}
