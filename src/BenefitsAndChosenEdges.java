import java.util.List;

public class BenefitsAndChosenEdges {
    private Float benefit;
    private List<Edge> edges;

    public BenefitsAndChosenEdges(Float benefit, List<Edge> edges) {
        this.benefit = benefit;
        this.edges = edges;
    }

    public Float getBenefit() {
        return benefit;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
