import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FileUtil {

    static GraphMembers getGraphStructureFromFile(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner sc = new Scanner(file);

        Boolean readTrip = false;
        Integer countTrip = 0;

        Boolean readEdge = false;
        Integer countEdge = 0;

        List<Vertice> trips = new LinkedList<Vertice>();
        Map<String, Vertice> mapTrip = new HashMap<String, Vertice>();
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

                    Vertice trip = new Vertice(tripId, isPassenger, isDriver, numberOfPassengers, capacity, tripDistance);

                    trips.add(trip);
                    mapTrip.put(trip.getVerticeId(), trip);

                    countTrip--;
                } else {
                    if (!readEdge) {
                        readEdge = true;
                        countEdge = Integer.parseInt(line);
                    } else {
                        if (countEdge > 0) {
                            String passenger = tokens[0];
                            String driver = tokens[1];

                            Vertice passengerObj = mapTrip.get(passenger);

                            // Somente adiciona a aresta se o passgeiro for realmente passageiro
                            if(passengerObj.isPassenger()) {
                                // Salva a aresta na lista de arestas
                                edges.add(new Edge(passenger, driver, mapTrip.get(passenger).getTripDistance()));
                            }

                            countEdge--;
                        }
                    }

                }
            }

        }

        return new GraphMembers(trips, edges);
    }

    static public void saveToFile(String outputPath, BenefitsAndChosenEdges chosenBenefitAndEdges) {
        // Formata e imprime no arquivo
        try{
            PrintWriter w = new PrintWriter(outputPath, "UTF-8");
            w.println(chosenBenefitAndEdges.getSharedTrips() + " " + chosenBenefitAndEdges.getBenefit());

            // Monta as linhas com os diferentes motoristas
            Map<String, List<String>> driverPassengers = new HashMap<>();

            for(Edge e : chosenBenefitAndEdges.getEdges()) {

                if(driverPassengers.get(e.getDriver()) == null) {
                    driverPassengers.put(e.getDriver(), new LinkedList<String>());
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
    }
}
