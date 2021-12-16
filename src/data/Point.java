package data;

import java.util.Vector;


public class Point {
    private Vector<Voyage> voyages;

    public Point(Vector<Voyage> voyages) {
        this.voyages = voyages;
    }

    public Vector<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(Vector<Voyage> voyages) {
        this.voyages = voyages;
    }
    public void print(){
        System.out.print(this.toString());
    }

    @Override
    public String toString() {
        return "Point\n{" +
            "\nvoyages=" + voyages +
            "\n}";
    }
}
