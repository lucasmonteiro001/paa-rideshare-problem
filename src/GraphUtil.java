import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtil {

    static Graph getBuiltGraph(List<Vertice> vertices, List<Edge> edges) {

        Graph graph = new Graph();

        // Cria um mapa para acessar os vertices
        Map<String, Vertice> verticeMap = new HashMap<>();

        for (Vertice v : vertices) {
            verticeMap.put(v.getVerticeId(), v);
        }

        Map<String, Vertice> graphMapVertices = new HashMap<>();

        // Faz uma copia de todos os vertices
        for (Vertice v : vertices) {
            Vertice verticeClone = new Vertice(v.getVerticeId(), v.isPassenger(), v
                    .isDriver(), v.getNumberOfPassengers(), v.getCapacity(), v.getTripDistance());
            graphMapVertices.put(verticeClone.getVerticeId(), verticeClone);
        }

        // Faz as ligações de aresta
        for (Edge e : edges) {
            Vertice driverAux = verticeMap.get(e.getDriver());

            // Adiciona a aresta do passageiro para o motorista
            graphMapVertices.get(e.getPassenger()).getAdjacentVertices().add(driverAux);
        }

        // Insere os vertices no grafo
        for (Map.Entry<String, Vertice> Entry : graphMapVertices.entrySet()) {
            graph.getVertices().add(Entry.getValue());
        }

        return graph;
    }
}
