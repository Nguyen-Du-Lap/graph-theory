package baitaptrenlop;

public class Test {
    public static void main(String[] args) {
        Graph G1 = new UnDirectedGraph();
        G1.addEdge(0, 1);
        G1.addEdge(0, 4);
        G1.addEdge(0, 4);
        G1.addEdge(0, 3);
        G1.addEdge(1, 1);
        G1.addEdge(1, 2);
        G1.addEdge(3, 4);
        G1.print();

        G1.removeEdge(0, 1);
        G1.print();
        System.out.println(G1.degree(0));
    }
}
