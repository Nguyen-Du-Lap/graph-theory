package baithuchanh1.bai2;

import java.util.*;

public class UnDirectedGraph extends Graph {
    public UnDirectedGraph(int vertex) {
        super(vertex);
    }

    @Override
    public void removeEdge(int i, int j) {
        try {
            ArrayList<Integer> listI = this.adjMap.get(i);
            ArrayList<Integer> listJ = this.adjMap.get(j);
            listI.remove(Integer.valueOf(j));
            listJ.remove(Integer.valueOf(i));
            if(listI.isEmpty()) {
                this.adjMap.remove(i);
                vertex--;
            } else this.adjMap.put(i, listI);

            if(listJ.isEmpty()) {
                this.adjMap.remove(j);
                vertex--;
            } else this.adjMap.put(j, listJ);
        }catch (NullPointerException e) {
            System.out.println(e);
            System.out.printf("vertices %d or %d is null\n", i, j);
        }

    }

    @Override
    public int degree(int v) {
        try {
            return this.adjMap.get(v).size();
        }catch (NullPointerException e) {
            System.out.println(e);
            System.out.printf("vertices %d is null \n", v);
        }
        return 0;
    }

    @Override
    public int edges() {
        int edges = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : this.adjMap.entrySet()) {
            edges += entry.getValue().size();
        }
        return edges / 2;
    }

    @Override
    public boolean isCheckerBipartite() {
        int[] colors = new int[vertex];
        final int NONE_COLOR = 0;
        final int RED_COLOR = 1;
        final int GREEN_COLOR = 2;
        for(int i = 0; i < vertex; i++) {
            colors[i] = NONE_COLOR;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, ArrayList<Integer>> entry: adjMap.entrySet()) {
            // nodeStart = 0
            int nodeStart = entry.getKey();
            queue.add(nodeStart);
            colors[nodeStart] = RED_COLOR;
            while(!queue.isEmpty()) {
                int node = queue.poll();
                int colorCurrent = colors[node];
                int colorNext = colorCurrent == RED_COLOR ? GREEN_COLOR : RED_COLOR;
                List<Integer> listNeighbor = this.adjMap.get(node);
                for(int n : listNeighbor) {
                    queue.add(n);
                    if(colors[n] == colorCurrent) return false;
                    else colors[n] = colorNext;
                }
            }
        }

        return true;
    }


}
