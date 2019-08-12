import java.util.*;

public class s3_2014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0; i<T; i++) {
            int N = sc.nextInt();
            Stack<Integer> cars = new Stack<>();
            Stack<Integer> branch = new Stack<>();
            String out = "";

            for (int j=0; j<N; j++) {
                cars.push(sc.nextInt());
            }
            int num = 1;

            while (cars.size() > 0 || branch.size() > 0) {
                while (branch.size() > 0 && branch.peek() == num) {
                    branch.pop();
                    num++;
                }
                if (cars.size() == 0 && branch.size() > 0 && branch.peek() != num) {
                    out = "N";
                    break;
                }

                if (cars.size() > 0) {
                    int a = cars.pop();
                    if (a != num) {
                        branch.push(a);
                    }
                    else {
                        num++;
                    }
                }
            }

            if (branch.size() == 0) {
                out = "Y";
            }
            System.out.println(out);
        }
    }
}
