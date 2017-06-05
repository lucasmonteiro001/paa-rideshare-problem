import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "/Users/lucas/Documents/ride-sharing-problem/toy_tests/toy_8.in";

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

        BenefitsAndChosenEdges b = BenefitsAndChosenEdges.getMaxBenefit(listBenefitsAndChosenEdges);

        // Formata e imprime no arquivo
        try{
            PrintWriter w = new PrintWriter("saida.txt", "UTF-8");
            w.println(b.getSharedTrips() + " " + b.getBenefit());

            // Monta as linhas com os diferentes motoristas
            Map<String, List<String>> driverPassengers = new HashMap<>();

            for(Edge e : b.getEdges()) {

                if(driverPassengers.get(e.getDriver()) == null) {
                    driverPassengers.put(e.getDriver(), new LinkedList<>());
                }

                driverPassengers.get(e.getDriver()).add(e.getPassenger());
            }

            for (Map.Entry<String, List<String>> Entry: driverPassengers.entrySet()) {

                String aux = "";

                for (String passengerId : Entry.getValue()) {
                    aux += " " + passengerId;
                }
                w.println(Entry.getKey() + aux);
            }

            System.out.println(driverPassengers);


            w.close();
        } catch (IOException e) {
            // do something
        }


        System.out.println("Beneficio maximo: " + b.getBenefit());
        System.out.println("Arestas" + b.getEdges());


        System.out.println("fim");

    }
}
