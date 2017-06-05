import java.util.List;

public class GraphMembers {
    List<Trip> vertices;
    List<Edge> edges;

    public GraphMembers(List<Trip> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Trip> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
