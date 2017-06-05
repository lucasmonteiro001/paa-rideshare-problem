import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "/Users/lucas/Documents/ride-sharing-problem/toy_tests/toy_6.in";

        List<BenefitsAndChosenEdges> benefits = new LinkedList<>();

        GraphMembers gm = FileUtil.getGraphStructureFromFile(inputPath);

        List<List<Edge>> allCombinations = Combination.getCombinations(gm.getEdges());

        List<BenefitsAndChosenEdges> listBenefitsAndChosenEdges = new LinkedList<>();

        // Monta o grafo para cada lista de combinacoes
        for (List<Edge> edges : allCombinations) {

            // Cria uma lista para acessar os vertices, fazenda a copia de cada um para poder

            List<Vertice> vertices = new LinkedList<>();

            // Faz uma copia de todos os vertices
            for (Vertice v : gm.getVertices()) {
                Vertice verticeClone = new Vertice(v.getVerticeId(), v.isPassenger(), v
                        .isDriver(), v.getNumberOfPassengers(), v.getCapacity(), v.getTripDistance());
                vertices.add(verticeClone);
            }

            Graph graph = GraphUtil.getBuiltGraph(vertices, edges);

//            System.out.println("Graph instance: " + Graph.instance);

            BenefitsAndChosenEdges benefitAndChosenEdges = GraphUtil.getGraphTotalBenefit(graph);

            listBenefitsAndChosenEdges.add(benefitAndChosenEdges);
        }

        // Ordena a lista de beneficio
        Collections.sort(listBenefitsAndChosenEdges, Collections.reverseOrder());

        // Obtém o primeiro benefício válido
        for(BenefitsAndChosenEdges b : listBenefitsAndChosenEdges) {
            Set<String> allPassengers = new HashSet<>();
            Set<String> allDrivers = new HashSet<>();
            Boolean isValid = true;

            for (Edge e : b.getEdges()) {
                String passengerId = e.getPassenger();
                String driverId = e.getDriver();

                // Um motorista nao pode ser passageiro e vice versa.
                if(allPassengers.contains(driverId)) {
                    isValid = false;
                    break;
                }
                if(allDrivers.contains(passengerId)) {
                    isValid = false;
                    break;
                }

                allPassengers.add(passengerId);
                allDrivers.add(driverId);
            }

            if(isValid) {
                System.out.println("Beneficio maximo: " + b.getBenefit());
                System.out.println("Arestas" + b.getEdges());
                break;
            }
        }

        System.out.println("fim");

    }
}
