import java.util.*;
import java.io.*;

public class Queens {

    public static void main(String[] args){
	//if args length > 2 || < 1, error                                      
        //else if args length is 2                                              
          //check args[0] is -v                                                 
          //check args[1] is int                                                
	//else                                                                  
        //args length is 1, check if args[0] is int                             

        int n, sum, str = 0;
        if(args.length >  2 || args.length < 1){
            System.err.println("Usage: Queens [-v] number\n" +  "Option: -v verbose output, print all solutions");
            System.exit(1);
        }
        else if(args.length == 2){
            if(args[0].equals("-v")){
                str = Integer.parseInt(args[1]);
                int[][] B = new int[str + 1][str + 1];
                sum = findSolutions(B, 1, "verbose");
                System.out.println(str + "-Queens has " + sum + " solutions.");
            }
            else{
                try{
                str = Integer.parseInt(args[0]);
                int[][] B = new int[str + 1][str + 1];
                sum = findSolutions(B, 1, "");
                System.out.println(str + "-Queens has " + sum + " solutions.");
                }
                catch (NumberFormatException e){
                    System.err.println("Usage: Queens [-v] number\n" +  "Option: -v verbose output, print all solutions");
                    System.exit(1);
                }
           }
        }
        else{
            if(args.length == 1){
                try{
                    str = Integer.parseInt(args[0]);
                    int[][] B = new int[str + 1][str + 1];
                    sum = findSolutions(B, 1, "");
                    System.out.println(str + "-Queens has " + sum + " solutions.");
                }
                catch (NumberFormatException e){
                    System.err.println("Usage: Queens [-v] number\n" +  "Option: -v verbose output, print all solutions");
                    System.exit(1);
                }
            }
        }

    }
    static void placeQueen(int[][] B, int i, int j) {
        //puts queen on line                                                                                                  
        B[i][j] = 1;
        //says that queen is on that row                                                                                      
        B[i][0] = j;

        int r, c;

        //decrements in column                                                                                                
        for(r = i + 1; r < B.length; r++) {
            B[r][j] -= 1;
        }

        //decrements right diagonal                                                                                           
        for(r = i + 1, c = j + 1; r < B.length && c < B.length; r++, c++) {
            B[r][c] -= 1;
        }

        //decrements left diagonal                                                                                            
        for(r = i + 1, c = j - 1; r < B.length && c > 0; r++, c--) {
            B[r][c] -= 1;
        }
    }

    static void removeQueen(int[][] B, int i, int j) {
        //removes queen on that line                                                                                          
        B[i][j] = 0;
        //tells code that there is no queen on that row                          
        B[i][0] = 0;

        int r, c;
        //increments in column                                                                                                
        for(r = i + 1; r < B.length; r++) {
            B[r][j] += 1;
        }

        //increments right diagonal                                                                                           
        for(r = i + 1, c = j + 1; r < B.length && c < B.length; r++, c++) {
            B[r][c] += 1;
        }

        //increments left diagonal                                                                                            
        for(r = i + 1, c = j - 1; r < B.length && c >= 0; r++, c--) {
            B[r][c] += 1;
        }

    }

    static void printBoard(int[][] B) {

        int[] print = new int[B.length - 1];

        for(int i = 0; i < B.length - 1; i++) {
            print[i] = B[i + 1][0];
        }

        System.out.println(Arrays.toString(print).replaceAll("\\[",  "\\(").replaceAll("\\]",  "\\)"));

    }

    static int findSolutions(int[][] B, int i, String mode) {

        int sum = 0;
        int n = B.length - 1;

        //solution was found on row                                                                                           
        if(i > n) {
            if(mode.equals("verbose")) {
                printBoard(B);
            }
            return 1;
        }
        else {
            for(int j = 1; j < B[i].length; j++){
                if(B[i][j] == 0) {
                    placeQueen(B, i, j);
                    sum += findSolutions(B, i + 1, mode);
                    removeQueen(B, i, j);
                }
            }
       }

        return sum;
    }

}
