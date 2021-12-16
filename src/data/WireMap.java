package data;

import algorithms.Dijkstra;
import algorithms.Floyd;
import algorithms.FordBellman;

import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.util.Vector;

public class WireMap {
    private Point[] matrix;

    public WireMap(Point[] matrix) {
        this.matrix = matrix;
    }

    public Vector<Integer>  getBestTripByPrice(int src, int dest) {
        try {

            if (src > matrix.length - 1 || src < 0) {
                throw new Exception("Source prop out of bound!");
            }

            if (dest > matrix.length - 1 || dest < 0) {
                throw new Exception("Dest prop out of bound!");
            }
            return Dijkstra.dijkstra(src, dest, matrix, true);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return new Vector<>();
        }
    }

    public Vector<Integer> getBestTripByTime(int src, int dest) {
        try {
            GraphEdge graphEdge = getGraphEdge(false);
            return FordBellman.fordBellman(src, dest, graphEdge);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return new Vector<>();
        }
    }

    public GraphEdge getGraphEdge(boolean isCost){
        Vector<Edge> tempGraph = new Vector<>();
        for (int i = 0; i < matrix.length; i++) {
            Vector<Voyage> voyages = matrix[i].getVoyages();
            for (int j = 0; j < voyages.size(); j++) {
                tempGraph.add(new Edge(i, voyages.get(j).getDestinationPoint(), isCost ? voyages.get(j).getCostOfVoyage() :voyages.get(j).getTimeToMove().toDouble()));
            }
        }
        return new GraphEdge(tempGraph.toArray(new Edge[tempGraph.size()]), matrix.length, tempGraph.size());

    }

    public AdjacencyMatrix getAdjacencyMatrix(boolean isCost){
         double[][] adjMatrix = new double[matrix.length][matrix.length];
         for (int i = 0; i < matrix.length; i++){
             for (int j = 0; j < matrix.length; j++){
                 adjMatrix[i][j] = Double.MAX_VALUE;
             }
         }
         for (int i = 0; i < matrix.length; i++){
             for (int j = 0; j < matrix[i].getVoyages().size(); j++){
                 adjMatrix[i][matrix[i].getVoyages().get(j).getDestinationPoint()] = isCost ? matrix[i].getVoyages().get(j).getCostOfVoyage() : matrix[i].getVoyages().get(j).getTimeToMove().toDouble();
             }
         }
         return new AdjacencyMatrix(adjMatrix);
    }


    public Vector<Integer> getBestTripOptimal(int src, int dest) {
        Vector<Integer> path = Floyd.floydWarshall(0,5, getAdjacencyMatrix(true));

        return path;
    }

    public void print() {
        System.out.println("WireMap{\n matrix= ");
        for (Point pt : matrix) {
            pt.print();
        }
    }

    @Override
    public String toString() {
        return "WireMap{" +
            "matrix=" + Arrays.toString(matrix) +
            '}';
    }
}
