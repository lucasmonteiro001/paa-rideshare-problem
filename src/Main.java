import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

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

        List allCombinations = Combination.getCombinations(edges);

        System.out.println(allCombinations);


    }
}
