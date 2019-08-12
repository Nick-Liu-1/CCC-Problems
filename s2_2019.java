import java.util.*;

public class s2_2019 {
    /*public static int[] sieve (int n) {
        n *= 2;
        boolean[] prime = new boolean[n];
        for(int i=0;i<n;i++) {
            prime[i] = true;
        }
        for (int p=2; p*p<n; p++) {
            if (prime[p]) {
                for (int i=p*p; i<n; i+=p) {
                    prime[i] = false;
                }
            }
        }

        ArrayList out = new ArrayList();
        for (int i=2; i<n; i++) {
            if (prime[i]) {
                out.add(i);
            }
        }

        int[] arr = out.stream().mapToInt(i -> (int) i).toArray();
        return arr;
    }

    public static int[] find (int n, int[] primes) {
        int low = 0;
        int high = primes.length - 1;
        int[] out = new int[2];
        while (low < primes.length && high > 0) {
            if (primes[low] + primes[high] == 2*n) {
                out[0] = primes[low];
                out[1] = primes[high];
                return out;
            }
            else if (primes[low] + primes[high] > 2*n) {
                high--;
            }
            else if (primes[low] + primes[high] < 2*n) {
                low++;
            }
        }
        return new int[] {0, 0};
    }*/



    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        else if (n == 2 || n == 3) {
            return true;
        }
        else {
            for (int i=2; i*i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void findPair(int n) {
        int a = 3;
        int b = 2*n - 3;
        while (a <= b) {
            if (isPrime(a) && isPrime(b)) {
                System.out.println(a + " " + b);
                return;
            }
            a += 2;
            b -= 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=0; i<N; i++) {
            int n = sc.nextInt();
            findPair(n);
            //int[] out = find(n, sieve(n));
            //System.out.println(out[0] + " " + out[1]);
        }
    }
}
