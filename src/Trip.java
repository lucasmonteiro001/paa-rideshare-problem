/**
 * Created by lucas on 5/25/17.
 */
public class Trip {
    private Integer tripId;
    private Boolean isPassenger;
    private Boolean isDriver;
    private Integer numberOfPassengers;
    private Integer capacity;
    private Float tripDistance;

    public Trip(Integer tripId, Boolean isPassenger, Boolean isDriver, Integer numberOfPassengers, Integer capacity, Float tripDistance) {
        this.tripId = tripId;
        this.isPassenger = isPassenger;
        this.isDriver = isDriver;
        this.numberOfPassengers = numberOfPassengers;
        this.capacity = capacity;
        this.tripDistance = tripDistance;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
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
}
