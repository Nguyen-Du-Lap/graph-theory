package baitaptrenlop;


import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DirectedGraph extends Graph {

    @Override
    public void addEdge(int i, int j) {
        Set<Integer> list = this.adjMap.get(i) == null ? new TreeSet<>() : this.adjMap.get(i);
        list.add(j);
        this.adjMap.put(i, list);
    }

    @Override
    public void print() {
        for(Map.Entry<Integer, Set<Integer>> entry : this.adjMap.entrySet()) {
            int key = entry.getKey();
            Set<Integer> values = entry.getValue();
            System.out.println(key+" | "+values);
        }
    }

    @Override
    public void removeEdge(int i, int j) {
        try {
            Set<Integer> list = this.adjMap.get(i);
            list.remove(j);
            if(list.isEmpty()) {
                this.adjMap.remove(i);
            } else this.adjMap.put(i, list);
        }catch (NullPointerException e) {
            System.out.println(e);
            System.out.printf("vertices %d or %d is null\n", i, j);
        }
    }

    @Override
    public int degree(int v) {
        return 0;
    }

    @Override
    public int degreeIn(int v) {
        int count = 0;
        for(Map.Entry<Integer, Set<Integer>> entry : adjMap.entrySet()) {
            for(int e : entry.getValue()) {
                if(v == e) count++;
            }
        }
        return count;
    }

    @Override
    public int degreeOut(int v) {
        return adjMap.get(v).size();
    }

    @Override
    public int edges() {
        int sum = 0;
        for(Map.Entry<Integer, Set<Integer>> entry : adjMap.entrySet()) {
            sum += entry.getValue().size();
        }
        return sum;
    }

    @Override
    public void edgeList() {

    }
}
