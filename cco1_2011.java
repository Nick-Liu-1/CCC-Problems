import java.util.*;

public class cco1_2011 {
    public static void find (double[] scores, double[] ranks, double k) {
        int i = 0;
        int low = 1;
        int high = (int) (2*ranks[0] - 1);

        while (scores[i] != k) {
            i++;
            low = high + 1;
            high = (int) (2*ranks[i] - low);

        }

        System.out.println(low);
        System.out.println(high);
        return;
    }

    static double[] reverse(double a[], int n) {
        double[] b = new double[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j--;
        }
        return b;
    }


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        double[] scores = new double[N];
        double[] ranks = new double[N];

        for (int i=0; i<N; i++) {
            String line = sc.nextLine();
            scores[i] = Double.parseDouble(line.split(" ")[0]);
            ranks[i] = Double.parseDouble(line.split(" ")[1]);
        }
        double key = Double.parseDouble(sc.nextLine());

        Arrays.sort(scores);
        Arrays.sort(ranks);

        scores = reverse(scores, scores.length);

        find(scores, ranks, key);

    }
}
