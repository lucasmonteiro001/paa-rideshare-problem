import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    /* arr[]  ---> Input Array
   data[] ---> Temporary array to store current combination
   start & end ---> Staring and Ending indexes in arr[]
   index  ---> Current index in data[]
   r ---> Size of a combination to be printed */
    static void combinationUtil(List arr, List data, int start,
                                int end, int index, int r, List allCombinations)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            List comb = new LinkedList();
            for (int j=0; j<r; j++)
                comb.add(data.get(j));

            allCombinations.add(comb);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data.add(index, arr.get(i));
            combinationUtil(arr, data, i+1, end, index+1, r, allCombinations);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static List printCombination(List arr, int n, int r)
    {
        // A temporary array to store all combination one by one
        List data = new ArrayList<>(r);

        List allCombinations = new LinkedList();

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r, allCombinations);

        return allCombinations;
    }


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/lucas/Documents/ride-sharing-problem/data/toy.txt");
        Scanner sc = new Scanner(file);

        Boolean readTrip = false;
        Integer countTrip = 0;

        Boolean readEdge = false;
        Integer countEdge = 0;

        List<Trip> trips = new LinkedList<Trip>();
        Map<String, Trip> mapTrip = new HashMap<String, Trip>();
        List<Edge> edges = new LinkedList<Edge>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Se é o primeiro elemento
            if (!readTrip) {
                readTrip = true;
                countTrip = Integer.parseInt(line);
            } else {
                if (countTrip > 0) {

                    String tripId = tokens[0];
                    Boolean isPassenger = tokens[1].equals("1");
                    Boolean isDriver = tokens[2].equals("1");
                    Integer numberOfPassengers = Integer.parseInt(tokens[3]);
                    Integer capacity = Integer.parseInt(tokens[4]);
                    Float tripDistance = Float.parseFloat(tokens[5]);

                    Trip trip = new Trip(tripId, isPassenger, isDriver, numberOfPassengers, capacity, tripDistance);

                    trips.add(trip);
                    mapTrip.put(trip.getTripId(), trip);

                    countTrip--;
                } else {
                    if (!readEdge) {
                        readEdge = true;
                        countEdge = Integer.parseInt(line);
                    } else {
                        if (countEdge > 0) {
                            String from = tokens[0];
                            String to = tokens[1];

                            // Salva a aresta na lista de arestas
                            edges.add(new Edge(from, to, mapTrip.get(from).getTripDistance()));

                            countEdge--;
                        }
                    }

                }
            }

        }

        System.out.println(trips);
        System.out.println(edges);

        List allCombinations = new LinkedList();

        for(int i = 0; i < edges.size() + 1; i++) {
            List combinations = printCombination(edges, edges.size(), i);

            for (Object c: combinations) {
                allCombinations.add(c);
            }
        }

        System.out.println(allCombinations);


    }
}
