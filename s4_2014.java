import java.util.*;
import java.io.*;

public class s4_2014 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int[][] data = new int[N][5];
        int[][] board = new int[1000][1000];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int[] g: data) {
            for (int i=g[0]; i<g[2]; i++) {
                for (int j=g[1]; j<g[3]; j++) {

                }
            }
        }
    }
}
