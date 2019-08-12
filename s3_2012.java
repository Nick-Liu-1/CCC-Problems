import java.util.*;

public class s3_2012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i<N; i++) {
            int reading = sc.nextInt();
            if (!freq.containsKey(reading)) {
                freq.put(reading, 1);
            }
            else {
                freq.put(reading, freq.get(reading) + 1);
            }
        }

        int max = 0;
        int max2 = 0;
        for (int value : freq.values()) {
            if (value > max) {
                max2 = max;
                max = value;
            }
            else if (value > max2) {
                max2 = value;
            }
        }

        ArrayList<Integer> highest = new ArrayList<>();
        ArrayList<Integer> highest2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value == max) {
                highest.add(key);
            }
            else if (value == max2) {
                highest2.add(key);
            }
        }

        int out;
        if (highest.size() > 1) {
            out = Collections.max(highest) - Collections.min(highest);
        }
        else {
            int a = Math.abs(highest.get(0) - Collections.min(highest2));
            int b = Math.abs(highest.get(0) - Collections.max(highest2));

            out = a > b ? a : b;
        }

        System.out.println(out);
    }
}
