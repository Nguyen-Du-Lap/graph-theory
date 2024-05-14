package baithuchanh1.bai1;

import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
    	UnDirectedTree g = new UnDirectedTree(11);
		g.setRoot(0);
		g.addEdge(0,1);
		g.addEdge(0,9);
		g.addEdge(1,2);
		g.addEdge(1,5);
		g.addEdge(1,6);
		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(6,7);
		g.addEdge(6,8);
		g.addEdge(9,10);
		g.printAdjList();
		System.out.println(g.isEnough());
		System.out.println(g.isTree());
		System.out.println(g.eccentricity(2));
		System.out.println(g.radius());
		System.out.println(g.centers());

    }
}
