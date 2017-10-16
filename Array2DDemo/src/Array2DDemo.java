/**
 * Created by KIT on 8/1/2015.
 */
public class Array2DDemo {
    public static void main (String[] args){
        System.out.println ("This is the array demo program.");
        // creating an array of 10 ints
        int[] smallCollection = new int[10];
        // set item 3 in the array to 50
        smallCollection[3] = 50;
        // matrix is a 2D array, 4 rows, 5 cols
        int[][] matrix = new int[4][5];
        // write a 12 into row 2, col 3
        matrix[2][3] = 12;
        // write a 18 into row 0, col 4
        matrix[0][4] = 18;

    }
}
