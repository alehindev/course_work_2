import data.*;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            File fileInput = new File("E:\\Java\\Course_Work\\src\\input.txt");
            Scanner sc = new Scanner(fileInput);
            int numberOfPoints = sc.nextInt();
            WireMap graph;
            if (numberOfPoints < 0) {
                throw new Exception("numberOfPoints less than 0");
            }
            Point[] matrix = new Point[numberOfPoints];

            for (int i = 0; i < numberOfPoints; i++) {
                Vector<Voyage> voyages = new Vector<>();

                for (int j = 0; j < numberOfPoints; j++) {
                    Voyage res;
                    String tempCortegeString = sc.next();

                    double cost = Double.parseDouble(tempCortegeString.substring(1, tempCortegeString.indexOf(',')));
                    //DDD:HH:MM:SS
                    TimePeriod time = new TimePeriod(tempCortegeString.substring(tempCortegeString.indexOf(',') + 1, tempCortegeString.indexOf(')')));
                    if (i == j || time == null || cost == 0) {
                        continue;
                    }
                    if (time.toDouble() < 0) {
                        throw new Exception("Time less than 0!");
                    }
                    if (cost < 0) {
                        throw new Exception("Cost of trip less than 0!");
                    }

                    res = new Voyage(j, i, time, cost);
                    voyages.add(res);
                }
                matrix[i] = new Point(voyages);
            }
            graph = new WireMap(matrix);
            Vector<Integer> path1 =graph.getBestTripByPrice(5, 0);
            Vector<Integer> path2 = graph.getBestTripByTime(5, 0);
            Vector<Integer> path3 = graph.getBestTripOptimal(5, 0 );
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
