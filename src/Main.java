import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "/Users/lucas/Documents/ride-sharing-problem/toy_tests/toy_0.in";

        List<BenefitsAndChosenEdges> benefits = new LinkedList<>();

        GraphMembers gm = FileUtil.getGraphStructureFromFile(inputPath);

        List<List<Edge>> allCombinations = Combination.getCombinations(gm.getEdges());

        // Monta o grafo para cada lista de combinacoes
        for (List<Edge> edges : allCombinations) {

            // Cria um mapa para acessar os vertices
            List<Vertice> vertices = new LinkedList<>();

            // Faz uma copia de todos os vertices
            for (Vertice v : gm.getVertices()) {
                Vertice verticeClone = new Vertice(v.getVerticeId(), v.isPassenger(), v
                        .isDriver(), v.getNumberOfPassengers(), v.getCapacity(), v.getTripDistance());
                vertices.add(verticeClone);
            }

            Graph graph = GraphUtil.getBuiltGraph(vertices, edges);

            System.out.println("Graph instance: " + Graph.instance);

            BenefitsAndChosenEdges benefitAndChosenEdges = GraphUtil.getGraphTotalBenefit(graph);

            System.out.println(benefitAndChosenEdges.getBenefit());
            System.out.println("=====");


        }


    }
}
