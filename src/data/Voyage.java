package data;

/**
 * todo Document type   Voyage
 */
public class Voyage {
    private int destinationPoint;
    private int sourcePoint;
    private TimePeriod timeToMove;
    private double costOfVoyage;

    public Voyage(int destinationPoint, int sourcePoint, TimePeriod timeToMove, double costOfVoyage) {
        this.destinationPoint = destinationPoint;
        this.sourcePoint = sourcePoint;
        this.timeToMove = timeToMove;
        this.costOfVoyage = costOfVoyage;
    }

    public int getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(int destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public int getSourcePoint() {
        return sourcePoint;
    }

    public void setSourcePoint(int sourcePoint) {
        this.sourcePoint = sourcePoint;
    }

    public TimePeriod getTimeToMove() {
        return timeToMove;
    }

    public void setTimeToMove(TimePeriod timeToMove) {
        this.timeToMove = timeToMove;
    }

    public double getCostOfVoyage() {
        return costOfVoyage;
    }

    public void setCostOfVoyage(double costOfVoyage) {
        this.costOfVoyage = costOfVoyage;
    }

    @Override
    public String toString() {
        return "Voyage{" +
            "\ndestinationPoint=" + destinationPoint +
            ",\nsourcePoint=" + sourcePoint +
            ",\ntimeToMove=" + timeToMove.toString() +
            ",\ncostOfVoyage=" + costOfVoyage +
            "\n}";
    }

}
