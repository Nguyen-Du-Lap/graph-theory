package baithuchanh1.bai1;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        Graph G1 = new UnDirectedGraph(5);
//        G1.addEdge(0, 1);
//        G1.addEdge(0, 1);
//        G1.addEdge(0, 2);
//        G1.addEdge(0, 3);
//        G1.addEdge(1, 2);
//        G1.addEdge(1, 4);
//        G1.addEdge(2, 3);
//        System.out.println(G1.isEuler());
//        Graph G2 = new UnDirectedGraph(9);
//        G2.addEdge(0, 3);
//        G2.addEdge(0, 6);
//        G2.addEdge(1, 3);
//        G2.addEdge(1, 5);
//        G2.addEdge(1, 6);
//        G2.addEdge(2, 3);
//        G2.addEdge(2, 5);
//        G2.addEdge(2, 6);
//        G2.addEdge(3, 4);
//        G2.addEdge(4, 5);
//        G2.addEdge(4, 6);
//        G2.addEdge(7, 8);
//        System.out.println(G2.isEuler());
//        Graph G3 = new DirectedGraph(6);
//        G3.addEdge(0, 1);
//        G3.addEdge(2, 1);
//        G3.addEdge(3, 0);
//        G3.addEdge(3, 2);
//        G3.addEdge(3, 4);
//        G3.addEdge(4, 5);
//
//        System.out.println(G1.isCheckerBipartite());
//        System.out.println(G2.isCheckerBipartite());
//        System.out.println(G3.isCheckerBipartite());

        Graph G4 = new UnDirectedGraph(5);
        G4.addEdge(0,4);
        G4.addEdge(0,1);
        G4.addEdge(1,4);
        G4.addEdge(2,3);
        G4.addEdge(2,4);
        G4.addEdge(3,4);
        System.out.println(G4.isEuler());
        Graph G5 = new UnDirectedGraph(4);
        G5.addEdge(0, 2);
        G5.addEdge(0, 2);
        G5.addEdge(0, 3);
        G5.addEdge(1, 2);
        G5.addEdge(1, 2);
        G5.addEdge(1, 3);
        G5.addEdge(2, 3);
        System.out.println(G5.isEuler());

    }
}
