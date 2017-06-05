import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BenefitsAndChosenEdges implements Comparable<BenefitsAndChosenEdges> {
    private Float benefit;
    private List<Edge> edges;


    public BenefitsAndChosenEdges() {
    }

    public BenefitsAndChosenEdges(Float benefit, List<Edge> edges) {
        this.benefit = benefit;
        this.edges = edges;
    }

    static BenefitsAndChosenEdges getMaxBenefit(List<BenefitsAndChosenEdges> listBenefitsAndChosenEdges) {

        // Ordena a lista de beneficio
        Collections.sort(listBenefitsAndChosenEdges, Collections.reverseOrder());

        // Obtém o primeiro benefício válido
        for (BenefitsAndChosenEdges b : listBenefitsAndChosenEdges) {
            Set<String> allPassengers = new HashSet<>();
            Set<String> allDrivers = new HashSet<>();
            Boolean isValid = true;

            for (Edge e : b.getEdges()) {
                String passengerId = e.getPassenger();
                String driverId = e.getDriver();

                // Um motorista nao pode ser passageiro e vice versa.
                if (allPassengers.contains(driverId)) {
                    isValid = false;
                    break;
                }
                if (allDrivers.contains(passengerId)) {
                    isValid = false;
                    break;
                }

                allPassengers.add(passengerId);
                allDrivers.add(driverId);
            }

            if (isValid) {
                return new BenefitsAndChosenEdges(b.getBenefit(), b.getEdges());
            }
        }
        return null;
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
