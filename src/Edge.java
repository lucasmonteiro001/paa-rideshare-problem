public class Edge {

    // From (tripId)
    private String passenger;
    // From (tripId)
    private String driver;
    private Float benefit;

    public Edge(String from, String to, Float benefit) {
        this.passenger = from;
        this.driver = to;
        this.benefit = benefit;
    }

    public Edge(String passengerId, String driverId) {
        this.passenger = passengerId;
        this.driver = driverId;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Float getBenefit() {
        return benefit;
    }

    public void setBenefit(Float benefit) {
        this.benefit = benefit;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "passenger=" + passenger +
                ", driver=" + driver +
                ", benefit=" + benefit +
                '}';
    }
}
