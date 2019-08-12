import java.util.*;

public class s3_2019 {
    public static int count (Integer[][] arr) {
        int count = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (arr[i][j] != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Integer[][] fill (Integer[][] arr) {
        boolean change = false;
        do {
            change = false;
            for (int i = 0; i < 3; i++) {
                if (arr[i][0] == null && arr[i][1] != null && arr[i][2] != null) {
                    arr[i][0] = 2*arr[i][1] - arr[i][2];
                    change = true;
                }
                else if (arr[i][1] == null && arr[i][0] != null && arr[i][2] != null) {
                    arr[i][1] = (arr[i][0] + arr[i][2]) / 2;
                    change = true;
                }
                else if (arr[i][2] == null && arr[i][0] != null && arr[i][1] != null) {
                    arr[i][2] = 2*arr[i][1] - arr[i][0];
                    change = true;
                }
            }

            for (int j=0; j<3; j++) {
                if (arr[0][j] == null && arr[1][j] != null && arr[2][j] != null) {
                    arr[0][j] = 2*arr[1][j] - arr[2][j];
                    change = true;
                }
                else if (arr[1][j] == null && arr[0][j] != null && arr[2][j] != null) {
                    arr[1][j] = (arr[0][j] + arr[2][j]) / 2;
                    change = true;
                }
                else if (arr[2][j] == null && arr[0][j] != null && arr[1][j] != null) {
                    arr[2][j] = 2*arr[1][j] - arr[0][j];
                    change = true;
                }
            }
        } while (change);

        return arr;
    }

    public static Integer[][] single (Integer[][] arr) {
        Integer[] toFill = null;
        boolean hor = false;
        for (int i=0; i<3; i++) {
            if (arr[i][0] != null && arr[i][1] != null && arr[i][2] != null) {
                toFill = arr[i];
                hor = true;
            } else if (arr[0][i] != null && arr[1][i] != null && arr[2][i] != null) {
                toFill = new Integer[]{arr[0][i], arr[1][i], arr[2][i]};
            }
        }
        if (toFill != null) {
            if (hor){
                for (int j=0; j<3; j++) {
                    arr[j] = toFill;
                }
            }
            else {
                for (int j=0; j<3; j++) {
                    for (int k=0; k<3; k++) {
                        arr[k][j] = toFill[k];
                    }
                }
            }
        }

        return arr;
    }

    public static Integer[][] tOrL (Integer[][] arr) {
        int d = 0;
        if (arr[1][1] == null) {
            for (int i=0; i<3; i++) {
                if (arr[i][0] != null && arr[i][1] != null) {
                    d = arr[i][1] - arr[i][0];
                }
            }
            if (arr[1][0] != null) {
                arr[1][1] = arr[1][0] + d;
            }
            else if (arr[1][2] != null) {
                arr[1][1] = arr[1][2] - d;
            }
        }
        else {
            if (arr[1][0] == null) {
                d = arr[1][1] - arr[0][1];
                if (arr[0][0] != null) {
                    arr[1][0] = arr[0][0] + d;
                }
                else {
                    arr[1][0] = arr[2][0] - d;
                }
            }
            else if (arr[0][1] == null) {
                d = arr[1][1] - arr[1][0];
                if (arr[0][0] != null) {
                    arr[0][1] = arr[0][0] + d;
                }
                else {
                    arr[0][1] = arr[0][2] - d;
                }
            }
            else if (arr[0][1] != null && arr[1][0] != null) {
                d = arr[1][1] - arr[1][0];
                arr[0][0] = arr[0][1] - d;
            }
        }
        return arr;
    }

    public static Integer[][] lessThanTwo (Integer[][] arr, int count) {
        if (count == 0) {
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        else if (count == 1) {
            int n = 0;
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (arr[i][j] != null) {
                        n = arr[i][j];
                    }
                }
            }
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    arr[i][j] = n;
                }
            }
        }
        else {
            boolean found = false;
            int a, b;
            int[][] coord = new int[2][2];
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (arr[i][j] != null) {
                        if (found) {
                            b = arr[i][j];
                            coord[1] = new int[]{i, j};
                        }
                        else {
                            a = arr[i][j];
                            coord[0] = new int[]{i, j};
                            found = true;
                        }
                    }
                }
            }
            if (coord[0][1] - coord[1][1] == 1 || coord[0][1] - coord[1][1] == -1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (arr[i][j] != null) {
                            int temp = arr[i][j];
                            for (int k = 0; k < 3; k++) {
                                arr[k][j] = temp;
                            }
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (arr[i][j] != null) {
                            int temp = arr[i][j];
                            for (int k = 0; k < 3; k++) {
                                arr[i][k] = temp;
                            }
                        }
                    }
                }
            }
        }
        return arr;
    }

    public static Integer[][] three (Integer[][] arr) {
        int n = 0;
        for (int i=0; i<3; i++) {
            if (arr[1][i] != null) {
                n = arr[1][i];
            }
        }
        for (int i=0; i<3; i++) {
            arr[1][i] = n;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[][] square = new Integer[3][3];
        for (int i=0; i<3; i++) {
            String line[] = sc.nextLine().split(" ");
            for (int j=0; j<3; j++) {
                if (!line[j].equals("X")) {
                    square[i][j] = Integer.parseInt(line[j]);
                }
                else {
                    square[i][j] = null;
                }
            }
        }
        // Case 1: blindly fill in
        fill(square);

        // Case 2: single row or column
        if (count(square) == 3) {
            single(square);
        }

        // Case 3: T or L
        if (count(square) == 5) {
            tOrL(square);
            fill(square);
        }

        // Case 4: 2 or less numbers
        if (count(square) <= 2) {
            lessThanTwo(square, count(square));
            fill(square);
        }

        // Case 5: 3 numbers none in same row or col
        if (count(square) == 3) {
            three(square);
            fill(square);
        }

        for (int i=0; i<3; i++) {
            System.out.println(square[i][0] + " " + square[i][1] + " " + square[i][2]);
        }
    }
}
