package baitaptrenlop;

import java.util.*;

public class UnDirectedGraph extends Graph {

    @Override
    public void addEdge(int i, int j) {
        Set<Integer> listI = this.adjMap.get(i) == null ? new TreeSet<>() : this.adjMap.get(i);
        Set<Integer> listJ = this.adjMap.get(j) == null ? new TreeSet<>() : this.adjMap.get(j);
        listI.add(j);
        listJ.add(i);
        this.adjMap.put(i, listI);
        this.adjMap.put(j, listJ);
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
            Set<Integer> listI = this.adjMap.get(i);
            Set<Integer> listJ = this.adjMap.get(j);
            listI.remove(j);
            listJ.remove(i);
            if(listI.isEmpty()) {
                this.adjMap.remove(i);
            } else this.adjMap.put(i, listI);

            if(listJ.isEmpty()) {
                this.adjMap.remove(j);
            } else this.adjMap.put(j, listJ);
        }catch (NullPointerException e) {
            System.out.println(e);
            System.out.printf("vertices %d or %d is null\n", i, j);
        }
    }

    @Override
    public int degree(int v) {
        return adjMap.get(v).size();
    }

    @Override
    public int degreeIn(int v) {
        return 0;
    }

    @Override
    public int degreeOut(int v) {
        return 0;
    }

    @Override
    public int edges() {
        int count = 0;
        for(Map.Entry<Integer,Set<Integer>> entry : adjMap.entrySet()) {
            count += entry.getValue().size();
        }
        return count/2;
    }

    @Override
    public void edgeList() {

    }


}
