import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "/Users/lucas/Documents/ride-sharing-problem/toy_tests/toy_0.in";

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

            BenefitsAndChosenEdges benefitAndChosenEdges = GraphUtil.getGraphTotalBenefit(graph);

            listBenefitsAndChosenEdges.add(benefitAndChosenEdges);
        }

        BenefitsAndChosenEdges chosenBenefitsAndEdges = BenefitsAndChosenEdges.getMaxBenefit
                (listBenefitsAndChosenEdges);

        FileUtil.saveToFile("saida.txt", chosenBenefitsAndEdges);


        System.out.println("Beneficio maximo: " + chosenBenefitsAndEdges.getBenefit());
        System.out.println("Arestas" + chosenBenefitsAndEdges.getEdges());


        System.out.println("fim");

    }
}
