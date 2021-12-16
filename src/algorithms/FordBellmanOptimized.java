package algorithms;

import data.Edge;
import data.GraphEdge;

import java.util.Collections;
import java.util.Vector;

/**
 * todo Document type FordBellmanOptimized
 */
public class FordBellmanOptimized {
    public static Vector<Integer> fordBellman(int source, int dest, GraphEdge graph) {
        try {
            //Arrange
            int countV = graph.getCountV();
            int countE = graph.getCountE();
            Edge[] edges = graph.getEdges();
            if (countV < 1) {
                throw new Exception("Empty matrix");
            }
            double[] distance = new double[countV];
            int[] parents = new int[countV];

            for (int i = 0; i < countV; i++) {
                distance[i] = Double.MAX_VALUE;
                parents[i] = -1;
            }
            distance[source] = 0;


            //Act
            // realisation of optimization
            for (;;){
                boolean any = false;
                for (int j = 0; j < countE; j++){
                    if (distance[edges[j].getSrc()] < Double.MAX_VALUE){
                        if (distance[edges[j].getDest()] > distance[edges[j].getSrc()] + edges[j].getWeight()) {
                            distance[edges[j].getDest()] =  distance[edges[j].getSrc()] + edges[j].getWeight();
                            parents[edges[j].getDest()] = edges[j].getSrc();
                            any = true;
                        }
                    }
                }
                if (any == false) {
                    break;
                }
            }

            //path recovery
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
        }
        return new Vector<>();
    }

}
