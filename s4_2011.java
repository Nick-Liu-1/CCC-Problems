import java.util.*;
import java.io.*;

public class s4_2011 {
    public static void main(String[] args) throws IOException {
        boolean[][] canGet = {{true, false, false, false, false, false, false, false},
                                {true, true, false, false, false, false, false, false},
                                {true, false, true, false, false, false, false, false},
                                {true, true, true, true, false, false, false, false},
                                {true, false, false, false, true, false, false, false},
                                {true, true, false, false, true, true, false, false},
                                {true, false, true, false, true, false, true, false},
                                {true, true, true, true, true, true, true, true}};

        int[] order = {0, 2, 4, 6, 1, 3, 5, 7};
        int[] reverse = {7, 5, 3, 1, 6, 4, 2, 0};

        int[] s = new int[8];
        int[] p = new int[8];

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i=0; i<8; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(in.readLine());
        for (int i=0; i<8; i++) {
            p[i] = Integer.parseInt(st1.nextToken());
        }

        int start = 0;
        for (int i=0; i<p.length; i++) {
            start += p[i];
        }

        for (int i : order) {
            for (int j: reverse) {
                if (canGet[i][j]) {
                    if (p[i] > s[j]) {
                        p[i] -= s[j];
                        s[j] = 0;
                    }
                    else {
                        s[j] -= p[i];
                        p[i] = 0;
                        break;
                    }
                }
            }
        }

        int end = 0;
        for (int i=0; i<p.length; i++) {
            end += p[i];
        }

        System.out.println(start - end);
    }
}
