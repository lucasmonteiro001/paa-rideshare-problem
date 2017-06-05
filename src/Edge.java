public class Edge {

    // From (tripId)
    private String from;
    // From (tripId)
    private String to;
    private Float benefit;

    public Edge(String from, String to, Float benefit) {
        this.from = from;
        this.to = to;
        this.benefit = benefit;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
                "from=" + from +
                ", to=" + to +
                ", benefit=" + benefit +
                '}';
    }
}
