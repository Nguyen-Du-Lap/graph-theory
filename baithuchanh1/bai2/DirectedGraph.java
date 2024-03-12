package baithuchanh1.bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DirectedGraph extends Graph {

    public DirectedGraph(int vertex) {
        super(vertex);
    }

    @Override
    public void removeEdge(int i, int j) {
        try {
            ArrayList<Integer> listI = this.adjMap.get(i);
            listI.remove(Integer.valueOf(j));
            if(listI.isEmpty()) {
                this.adjMap.remove(i);
                vertex--;
            } else this.adjMap.put(i, listI);
        }catch (NullPointerException e) {
            System.out.println(e);
            System.out.printf("vertices %d is null\n", i);
        }
    }

    @Override
    public int degree(int v) {
        return 0;
    }

    public int degreeIn(int v) {
        int sum = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> entry: adjMap.entrySet()) {
            for(int e : entry.getValue()) if(e==v) sum++;
        }
        return sum;
    }

    public int degreeOut(int v) {
        try {
            return adjMap.get(v).size();
        }catch (NullPointerException e) {
            System.out.println(e);
            System.out.printf("Vertices %d is null", v);
        }
        return 0;
    }

    @Override
    public int edges() {
        return vertex;
    }


}
