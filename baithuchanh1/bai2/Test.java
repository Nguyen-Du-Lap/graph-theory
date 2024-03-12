package baithuchanh1.bai2;

public class Test {
    public static void main(String[] args) {
        Graph G1 = new UnDirectedGraph(5);
        G1.addEdge(0, 1);
        G1.addEdge(0, 3);
        G1.addEdge(0, 4);
        G1.addEdge(0, 2);
        G1.addEdge(1, 0);
        G1.addEdge(1, 2);
        G1.addEdge(1, 3);
        G1.addEdge(2, 0);
        G1.addEdge(2, 1);
        G1.addEdge(2, 3);
        G1.addEdge(3, 0);
        G1.addEdge(3, 1);
        G1.addEdge(3, 2);
        G1.addEdge(4, 0);
//
//        G1.adjacencyList();
////        System.out.println(G1.getAdjMatrix());
//        G1.removeEdge(0,4);
//        System.out.println(G1.vertex);
//        System.out.println(G1.edges());
//        System.out.println(G1.isCheckerBipartite());

//        Graph G3 = new DirectedGraph(6);
//        G3.addEdge(0, 1);
//        G3.addEdge(2, 1);
//        G3.addEdge(3, 0);
//        G3.addEdge(3, 2);
//        G3.addEdge(3, 4);
//        G3.addEdge(4, 5);
//        G3.edgeList();
//        System.out.println(G3.degreeIn(1));
//        System.out.println(G3.degreeOut(3));
    }
}
