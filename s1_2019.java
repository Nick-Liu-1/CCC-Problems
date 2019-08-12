import java.io.*;
import java.util.*;

public class s1_2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String moves = sc.nextLine();
        int[][] arr = {{1, 2}, {3, 4}};
        for (int i=0; i<moves.length(); i++) {
            if (moves.charAt(i) == 'H') {
                int[] a = arr[0];
                int[] b = arr[1];
                arr[0] = b;
                arr[1] = a;
            }
            else {
                for (int j=0; j<2; j++) {
                    int x = arr[j][0];
                    int y = arr[j][1];
                    arr[j][0] = y;
                    arr[j][1] = x;
                }
            }
        }
        System.out.println(arr[0][0] + " " + arr[0][1]);
        System.out.println(arr[1][0] + " " + arr[1][1]);
    }
}
