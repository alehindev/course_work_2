package data;

/**
 * todo Document type GraphEdge
 */
public class GraphEdge {
    private Edge[] edges;
    private int countV;
    private  int countE;

    public GraphEdge(Edge[] edges, int countV, int countE) {
        this.edges = edges;
        this.countV = countV;
        this.countE = countE;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    public int getCountV() {
        return countV;
    }

    public void setCountV(int countV) {
        this.countV = countV;
    }

    public int getCountE() {
        return countE;
    }

    public void setCountE(int countE) {
        this.countE = countE;
    }
}
