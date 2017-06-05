import java.util.LinkedList;
import java.util.List;

public class Graph {
    static Integer instance = 0;
    private List<Vertice> vertices = new LinkedList<>();

    public Graph(List<Vertice> vertices) {
        Graph.instance += 1;
        this.vertices = vertices;
    }

    public Graph() {
        Graph.instance += 1;
    }

    public static Integer getInstance() {
        return Graph.instance;
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
