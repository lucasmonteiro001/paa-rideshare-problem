import java.util.List;

public class BenefitsAndChosenEdges implements Comparable<BenefitsAndChosenEdges> {
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

    public void setBenefit(Float benefit) {
        this.benefit = benefit;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }


    @Override
    public int compareTo(BenefitsAndChosenEdges o) {
        return (int) (this.benefit - o.benefit);
    }
}
