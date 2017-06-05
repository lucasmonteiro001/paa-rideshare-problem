import java.util.List;

public class GraphMembers {
    private List<Vertice> vertices;
    private List<Edge> edges;

    public GraphMembers(List<Vertice> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
