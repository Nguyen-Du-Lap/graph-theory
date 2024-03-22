package baithuchanh2.bai1andbai3;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Graph g1 = new UnDirectedGraph("baithuchanh2/bai1andbai3/H1.txt");
//        g1.printMatrix();
//        System.out.println(g1.isSimpleGraph());
//        g1.bfs(5);
//        g1.dfs(5);
//        System.out.println(g1.isPath(0,5));
//        System.out.println(g1.countConnect());
//        Graph g3 = new UnDirectedGraph("baithuchanh2/bai1andbai3/H2.txt");
//        System.out.println(g3.isPath(0,8));
//        System.out.println(g3.countConnect());
        Graph g2 = new DirectedGraph("baithuchanh2/bai1andbai3/G1.txt");
//        g2.printMatrix();
//        g2.printListEdges();
//        g2.printAdjList();
//        System.out.println(g2.isSimpleGraph());
//        g2.bfs(1);
        System.out.println(g2.isConnect());
        System.out.println(g2.isPath(1, 0));
        System.out.println(g2.countConnect());
    }
}
