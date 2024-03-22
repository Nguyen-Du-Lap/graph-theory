package baithuchanh2.bai2andbai4;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Graph g1 = new UnDirectedGraph("baithuchanh2/bai2andbai4/G3.txt");
        Graph g2 = new UnDirectedGraph("baithuchanh2/bai2andbai4/H2.txt");
        g1.printAdjList();
//        g1.printMatrix();
//        g1.bfs(6);
//        g1.dfs(0);
//        g1.isConnect();
        System.out.println(g1.isPath(0, 8));
        System.out.println(g2.isPath(0, 8));
        System.out.println(g1.countConnect());
        System.out.println(g2.countConnect());

    }
}
