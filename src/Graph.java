import java.util.LinkedList;
import java.util.List;

public class Graph {
    private static Integer instance;
    private List<Vertice> vertices = new LinkedList<>();

    public Graph(List<Vertice> vertices) {
        Graph.instance += 1;
        this.vertices = vertices;
    }

    public Graph() {

    }

    public static Integer getInstance() {
        return instance;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public static void setInstance(Integer instance) {
        Graph.instance = instance;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
}
