import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {

    /* arr[]  ---> Input Array
   data[] ---> Temporary array to store current combination
   start & end ---> Staring and Ending indexes in arr[]
   index  ---> Current index in data[]
   r ---> Size of a combination to be printed */
    static private void combinationUtil(List arr, List data, int start,
                                int end, int index, int r, List allCombinations) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            List comb = new LinkedList();
            for (int j = 0; j < r; j++)
                comb.add(data.get(j));

            allCombinations.add(comb);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data.add(index, arr.get(i));
            combinationUtil(arr, data, i + 1, end, index + 1, r, allCombinations);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static private List getAllCombinations(List arr, int n, int r) {
        // A temporary array to store all combination one by one
        List data = new ArrayList<>(r);

        List allCombinations = new LinkedList();

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r, allCombinations);

        return allCombinations;
    }

    static List getCombinations(List arr) {
        List allCombinations = new LinkedList();

        for (int i = 0; i < arr.size() + 1; i++) {
            List combinations = Combination.getAllCombinations(arr, arr.size(), i);

            for (Object c : combinations) {
                allCombinations.add(c);
            }
        }
        return allCombinations;
    }
}
