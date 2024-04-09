package baithuchanh1.bai1;

import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
    	Graph g = new UnDirectedGraph("baithuchanh1/bai1/H1.txt");
    	g.printAdjList();
    	System.out.println(g.edges());
    	System.out.println(g.euler());
    	
    }
}
