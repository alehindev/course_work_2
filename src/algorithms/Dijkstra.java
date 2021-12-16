package algorithms;

import data.Point;

import java.util.Collections;
import java.util.Vector;

public class Dijkstra {
    public static Vector<Integer> dijkstra(int source, int dest, Point[] matrix, boolean isCost) {
        try {
            //arrange
            int countV = matrix.length;
            if (countV < 1) {
                throw new Exception("Empty matrix");
            }
            double[] distance = new double[countV];
            boolean[] used = new boolean[countV];
            int[] parents = new int[countV];

            for (int i = 0; i < countV; i++) {
                distance[i] = Double.MAX_VALUE;
                used[i] = false;
                parents[i] = -1;
            }
            distance[source] = 0;

            // act
            for (int i = 0; i < countV; i++) {
                int v = -1;
                for (int j = 0; j < countV; j++) {
                    if (!used[j] && (v == -1 || distance[j] < distance[v])) {
                        v = j;
                    }
                }
                if (distance[v] == Double.MAX_VALUE) {
                    break;
                }
                used[v] = true;

                for (int j = 0; j < matrix[v].getVoyages().size(); j++) {
                    int to = matrix[v].getVoyages().get(j).getDestinationPoint();
                    double weight = isCost ? matrix[v].getVoyages().get(j).getCostOfVoyage() : matrix[v].getVoyages().get(j).getTimeToMove().toDouble();
                    if (distance[v] + weight < distance[to]) {
                        distance[to] = distance[v] + weight;
                        parents[to] = v;
                    }
                }
            }
            Vector<Integer> path = new Vector<>();
            path.add(dest);
            while (dest != source) {
                if (parents[dest] == -1) {
                    throw new Exception("No way to dest point!");
                }
                path.add(parents[dest]);
                dest = parents[dest];
            }
            Collections.reverse(path);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return new Vector<>();
        }
    }
}
