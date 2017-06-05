import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "/Users/lucas/Documents/ride-sharing-problem/data/toy.txt";

        GraphMembers gm = FileUtil.getGraphStructureFromFile(inputPath);

        System.out.println(gm.getVertices());
        System.out.println(gm.getEdges());

        List allCombinations = Combination.getCombinations(gm.getEdges());

        System.out.println(allCombinations);


    }
}
