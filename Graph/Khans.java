package Graph;

import java.util.*;

class Graph {
    private HashMap<Integer, List<Integer>> g;
    private HashMap<Integer,Integer> ingress;

    Graph(int n) {
        g = new HashMap<>();
        ingress = new HashMap<>();

    }

    private void addNodes(int n) {
        g.putIfAbsent(n, new ArrayList<>());
        ingress.putIfAbsent(n,0);
    }

    public void addEdges(int src, int des) {
        addNodes(src);
        addNodes(des);
        g.get(src).add(des);
        ingress.put(des,ingress.getOrDefault(des,0)+1);
    }

    public void topological_sort() {
        Integer src = 0;
        for (Map.Entry<Integer,Integer> e:ingress.entrySet()) {
            if (e.getValue() == 0) {
                src = e.getKey();
                break;
            }
        }
        System.out.println(g);
        topological_sort(src);
    }

    private void topological_sort(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println(cur);
            for (int a : g.get(cur)) {
                ingress.put(a,ingress.get(a)-1);
                if (ingress.get(a) == 0) {
                    q.add(a);
                }
            }
        }
    }
}

public class Khans {

    public static void main(String args[]) {
        Graph g = new Graph(9);
        g.addEdges(1,2);
        g.addEdges(1,3);
        g.addEdges(1,6);
        g.addEdges(3,4);
        g.addEdges(3,5);
        g.addEdges(3,2);
        g.addEdges(5,4);
        g.addEdges(5,8);
        g.addEdges(2,4);
        g.addEdges(2,6);
        g.addEdges(4,6);
        g.addEdges(4,7);
        g.addEdges(7,8);
        g.addEdges(7,9);
        g.addEdges(8,9);
        g.addEdges(7,6);
//        Graph g=new Graph(5);
//        g.addEdges(1,2);
//        g.addEdges(4,5);
//        g.addEdges(1,4);
//        g.addEdges(2,4);
//        g.addEdges(2,3);
        g.topological_sort();
    }
}
