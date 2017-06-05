import java.util.List;

public class BenefitsAndChosenEdges {
    private Float benefit;
    private List<Vertice> vertices;

    public BenefitsAndChosenEdges(Float benefit, List<Vertice> vertices) {
        this.benefit = benefit;
        this.vertices = vertices;
    }

    public BenefitsAndChosenEdges() {

    }

    public Float getBenefit() {
        return benefit;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setBenefit(Float benefit) {
        this.benefit = benefit;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
}
