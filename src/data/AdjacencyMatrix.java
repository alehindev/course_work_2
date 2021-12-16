package data;

/**
 * todo Document type AdjacencyMatrix
 */
public class AdjacencyMatrix {
    private double[][] matrix;

    public AdjacencyMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
    public void setValue(double value ,int rowIndex, int columnIndex){
        matrix[rowIndex][columnIndex] = value;
    }

    public double getValue(int rowIndex, int columnIndex){
        return matrix[rowIndex][columnIndex];
    }
}
