import java.io.*;
import java.util.*;

public class s3_2015 {
    private static boolean getClosest(ArrayList<Integer> arr, int k) {
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //System.out.println(k + " " + low + " " + high);
            if (arr.get(mid) == k) {
                arr.remove(mid);
                return true;
            }
            else if (k < arr.get(mid)) {
                if (mid == 0) {
                    return false;
                }
                else if (k > arr.get(mid-1)) {
                    arr.remove(mid-1);
                    return true;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                if (mid == arr.size() - 1) {
                    arr.remove(arr.size() - 1);
                    return true;
                }
                else if (k < arr.get(mid+1)) {
                    arr.remove(mid);
                    return true;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(in.readLine());
        int P = Integer.parseInt(in.readLine());

        ArrayList<Integer> gates = new ArrayList<>();
        for (int i=0; i<G; i++) {
            gates.add(i);
        }

        int count = 0;
        for (int i=0; i<P; i++) {
            boolean added = false;
            int p = Integer.parseInt(in.readLine()) - 1;
            if (getClosest(gates, p)) {
                count++;
                added = true;
            }
            if (!added) {
                break;
            }
        }
        System.out.println(count);
    }
}