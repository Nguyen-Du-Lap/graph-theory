package baithuchanh2.bai2andbai4;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Graph g1 = new UnDirectedGraph("baithuchanh2/bai2andbai4/G3.txt");
        Graph g2 = new UnDirectedGraph("baithuchanh2/bai2andbai4/H2.txt");
//        Graph g3 = new DirectedGraph("baithuchanh2/bai2andbai4/G2.txt");
        g1.printAdjList();
        System.out.println(g1.euler(0));
        System.out.println(g2.euler(0));
    }
}
