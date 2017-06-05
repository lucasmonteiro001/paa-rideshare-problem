import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "/Users/lucas/Documents/ride-sharing-problem/data/toy.txt";

        List<BenefitsAndChosenEdges> benefits = new LinkedList<>();

        GraphMembers gm = FileUtil.getGraphStructureFromFile(inputPath);

        // Cria um mapa para acessar os vertices
        Map<String, Vertice> verticeMap = new HashMap<>();

        for (Vertice v : gm.getVertices()) {
            verticeMap.put(v.getVerticeId(), v);
        }

        List<List<Edge>> allCombinations = Combination.getCombinations(gm.getEdges());

        // Monta o grafo para cada lista de combinacoes
        for (List<Edge> edges : allCombinations) {

            Graph graph = GraphUtil.getBuiltGraph(gm.getVertices(), gm.getEdges());

            System.out.print("grafo");


        }


    }
}
