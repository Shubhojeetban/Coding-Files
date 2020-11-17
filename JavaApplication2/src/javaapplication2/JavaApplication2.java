
package javaapplication2;

import java.util.Scanner;


public class JavaApplication2 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // number of trainees
        int m = scan.nextInt(); //number of rounds
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = scan.nextInt();
            }
        }

        int[] average = new int[n];
        int i = 0;
        //finding the average of the oxygen
        while (i < n) {
            int av = 0;
            for (int j = 0; j < m; j++) {
                av += ar[j][i];
            }
            average[i] = av/m;
            i++;
        }

        //finding the highest
        //if two oxygen levels are same then
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            if (average[j] > max) {
                max = average[j];
            }
        }
        if (max < 70) {
            System.out.println("All trainees are unfit");
        } else {
            
            System.out.println();
            for (int j = 0; j < n; j++) {
                if (average[j] == max) {
                    System.out.println("Trainee Number :" + (j + 1));
                }
            }
        }
    }
    
}
