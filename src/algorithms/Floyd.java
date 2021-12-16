package algorithms;

import data.AdjacencyMatrix;
import data.Point;

import java.util.Collections;
import java.util.Vector;
import java.util.regex.MatchResult;

/**
 * todo Document type Floid
 */
public class Floyd {
    public static Vector<Integer> floydWarshall(int source, int dest, AdjacencyMatrix matrix) {
        try {
            //arrange
            double[][] distance = matrix.getMatrix();

            int countV = distance.length;
            if (countV < 1) {
                throw new Exception("Empty matrix");
            }
            int[][] parents = new int[countV][countV];
            for (int i = 0; i < countV; i++){
                for (int j = 0; j < countV; j++){
                    parents[i][j] = i;
                }
            }
            distance[source][source] = 0;
            for (int k =0; k < countV; k++){
                for (int i = 0; i < countV; i++){
                    for (int j = 0; j < countV; j++){
                         if (distance[i][k] < Double.MAX_VALUE && distance[k][j] < Double.MAX_VALUE){
                             if (distance[i][k] + distance[k][j] < distance[i][j]) {
                                 distance[i][j] = distance[i][k] + distance[k][j];
                                 parents[i][j] = parents[k][j];
                             }
                         }
                    }
                }
            }
            Vector<Integer> path = new Vector<>();
            if (distance[source][dest] == Double.MAX_VALUE){
                throw new Exception("No path!");
            }
            int dst = dest;
            path.add(dst);
            while(dst != source){
                path.add(parents[source][dst]);
                dst =  (parents[source][dst]);
            }

            return path;
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
            return new Vector<>();
        }



    }
}
