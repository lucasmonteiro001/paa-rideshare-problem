import java.util.List;

public class Graph {
    private static Integer instance;
    private List<Vertice> vertices;

    public Graph(List<Vertice> vertices) {
        Graph.instance += 1;
        this.vertices = vertices;
    }

    public static Integer getInstance() {
        return instance;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }
}
