public class Vertice {
    private String verticeId;
    private Boolean isPassenger;
    private Boolean isDriver;
    private Integer numberOfPassengers;
    private Integer capacity;
    private Float tripDistance;

    public Vertice(String verticeId, Boolean isPassenger, Boolean isDriver, Integer numberOfPassengers, Integer capacity, Float tripDistance) {
        this.verticeId = verticeId;
        this.isPassenger = isPassenger;
        this.isDriver = isDriver;
        this.numberOfPassengers = numberOfPassengers;
        this.capacity = capacity;
        this.tripDistance = tripDistance;
    }

    public String getVerticeId() {
        return verticeId;
    }

    public void setVerticeId(String verticeId) {
        this.verticeId = verticeId;
    }

    public Boolean getPassenger() {
        return isPassenger;
    }

    public void setPassenger(Boolean passenger) {
        isPassenger = passenger;
    }

    public Boolean getDriver() {
        return isDriver;
    }

    public void setDriver(Boolean driver) {
        isDriver = driver;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Float getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(Float tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "verticeId=" + verticeId +
                ", isPassenger=" + isPassenger +
                ", isDriver=" + isDriver +
                ", numberOfPassengers=" + numberOfPassengers +
                ", capacity=" + capacity +
                ", tripDistance=" + tripDistance +
                '}' + "\n";
    }
}
