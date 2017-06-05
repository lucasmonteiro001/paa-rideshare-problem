import java.util.List;

public class BenefitsAndChosenEdges implements Comparable<BenefitsAndChosenEdges> {
    private Float benefit;
    private List<Edge> edges;


    public BenefitsAndChosenEdges() {
    }

    public Float getBenefit() {
        return benefit;
    }

    public void setBenefit(Float benefit) {
        this.benefit = benefit;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }


    @Override
    public int compareTo(BenefitsAndChosenEdges o) {
        return (int) (this.benefit - o.benefit);
    }
}
