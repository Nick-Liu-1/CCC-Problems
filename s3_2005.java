import java.io.*;
import java.util.*;

public class s3_2005 {
    private static int[][] tensorProduct(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int n = arr1[0].length;
        int p = arr2.length;
        int q = arr2[0].length;
        int[][] result = new int[m*p][n*q];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<p; k++) {
                    for (int ii=0; ii<q; ii++) {
                        result[i*p+k][j*q+ii] = arr1[i][j] * arr2[k][ii];
                    }
                }
            }
        }
        return result;
    }

    private static int getMax(int[][] arr) {
        int max = arr[0][0];
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    private static int getMin(int[][] arr) {
        int min = arr[0][0];
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }

    private static int getMaxRow(int[][] arr) {
        int max;
        int sum = 0;
        for (int i=0; i<arr[0].length; i++) {
            sum += arr[0][i];
        }
        max = sum;

        if (arr.length > 1) {
            for (int i=0; i<arr.length; i++) {
                sum = 0;
                for (int j=0; j<arr[i].length; j++) {
                    sum += arr[i][j];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private static int getMinRow(int[][] arr) {
        int min;
        int sum = 0;
        for (int i=0; i<arr[0].length; i++) {
            sum += arr[0][i];
        }
        min = sum;

        if (arr.length > 1) {
            for (int i=0; i<arr.length; i++) {
                sum = 0;
                for (int j=0; j<arr[i].length; j++) {
                    sum += arr[i][j];
                }
                if (sum < min) {
                    min = sum;
                }
            }
        }
        return min;
    }

    private static int getMaxCol(int[][] arr) {
        int max;
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i][0];
        }
        max = sum;

        if (arr[0].length > 1) {
            for (int i=0; i<arr[0].length; i++) {
                sum = 0;
                for (int j=0; j<arr.length; j++) {
                    sum += arr[j][i];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private static int getMinCol(int[][] arr) {
        int min;
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i][0];
        }
        min = sum;

        if (arr[0].length > 1) {
            for (int i=0; i<arr[0].length; i++) {
                sum = 0;
                for (int j=0; j<arr.length; j++) {
                    sum += arr[j][i];
                }
                if (sum < min) {
                    min = sum;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());


        int[][] prev = {{1}};
        for (int i=0; i<N; i++) {
            String[] line = in.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);
            int[][] next = new int[r][c];
            for (int j=0; j<r; j++) {
                String[] row = in.readLine().split(" ");
                for (int k=0; k<c; k++) {
                    next[j][k] = Integer.parseInt(row[k]);
                }
            }
            prev = tensorProduct(prev, next);
        }
        System.out.println(getMax(prev));
        System.out.println(getMin(prev));
        System.out.println(getMaxRow(prev));
        System.out.println(getMinRow(prev));
        System.out.println(getMaxCol(prev));
        System.out.println(getMinCol(prev));
    }
}
