package data;

/**
 * todo Document type TimePeriod
 */
public class TimePeriod {
    private int days;
    private int hours;
    private int min;
    private int sec;

    public TimePeriod(int days, int hours, int min, int sec) {
        this.days = days;
        this.hours = hours;
        this.min = min;
        this.sec = sec;
    }

    //constructor that will take str in format DDD:HH:MM:SS and will parse into class
    public TimePeriod(String str) {
        // temp vars
        int days = 0;
        int hours = 0;
        int min = 0;
        int sec = 0;

        //parsing
        days = Integer.parseInt(str.substring(0, 3));
        hours = Integer.parseInt(str.substring(4, 6));
        min = Integer.parseInt(str.substring(7, 9));
        sec = Integer.parseInt(str.substring(10, 12));

        this.days = days;
        this.hours = hours;
        this.min = min;
        this.sec = sec;
    }

    public double toDouble() {
        return days * 10e5 + hours * 10e3 + min * 10e1 + sec;
    }

    @Override
    public String toString() {
        return "TimePeriod{" +
            "days=" + days +
            ", hours=" + hours +
            ", min=" + min +
            ", sec=" + sec +
            '}';
    }
}
