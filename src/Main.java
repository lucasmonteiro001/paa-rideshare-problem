import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/lucas/Documents/ride-sharing-problem/data/toy.txt");
        Scanner sc = new Scanner(file);

        Boolean readTrip = false;
        Integer countTrip = 0;

        Boolean readEdge = false;
        Integer countEdge = 0;

        while(sc.hasNextLine()){
            String line = sc.nextLine();

            // Se é o primeiro elemento
            if(!readTrip) {
                readTrip = true;
                countTrip = Integer.parseInt(line);
            }
            else {
                if(countTrip > 0) {
                    System.out.println("Trip: " + line);
                    countTrip--;
                }
                else {
                    if(!readEdge) {
                        readEdge = true;
                        countEdge = Integer.parseInt(line);
                    }
                    else {
                        if(countEdge > 0) {
                            System.out.println("Edge: " + line);
                            countEdge--;
                        }
                    }

                }
            }

        }

    }
}
