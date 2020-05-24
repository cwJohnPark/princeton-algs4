package chapter1.programmingmodel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

import static chapter1.programmingmodel.BinarySearch.rank;
import static chapter1.programmingmodel.Exercises.euclid;

public class CreativeProblems {
    public static void main(String[] args) {
        //ex_1_1_26();
        //ex_1_1_27();
        //ex_1_1_28();
        //ex_1_1_29();
        //ex_1_1_30();
        //ex_1_1_31();
        //ex_1_1_32();
        ex_1_1_33();
    }

    private static void ex_1_1_33() {
        // write a library Matrix that implements the following API
        double[] x = {1,2,3};
        double[] y = {1,2,3};
        double resultVectorDot = Matrix.dot(x,y);
        //StdOut.println(resultVectorDot);

        double[][] a = {{1,0,0}, {0,1,0}, {0,0,1}};
        double[][] b = {{1},{2},{3}};
        double[][] resultMatrixMult = Matrix.mult(a,b);
        printMatrix(resultMatrixMult);
    }

    static void printMatrix(double[][] mat) {
        for(double[] row : mat) {
            StdOut.print(Arrays.toString(row));
        }
    }

    static class Matrix {
        // vector dot product
        static double dot(double[] x, double[] y) {
            double res = 0;
            if(x.length != y.length) {
                throw new IllegalArgumentException();
            }
            for(int i = 0; i < x.length; i++) {
                res += x[i] * y[i];
            }
            return res;
        }
        // matrix-matrix product
        static double[][] mult(double[][] a, double[][] b) {
            if(a[0].length != b.length) {
                throw new RuntimeException("the number of column of a and the number of rows of b should be equal");
            }
            double[][] product = new double[a.length][b[0].length];

            for(int i = 0; i < a.length; i++) {
                for(int j = 0; j < b[0].length; j++) {
                    double each = 0;
                    for(int k = 0; k < b.length; k++) {
                        each += a[i][k] * b[k][j];
                    }
                    product[i][j] = each;
                }
            }
            return product;
        }
        // transpose
        static double[][] transpose(double[][] a) {
            return null;
        }

        // matrix-vector product
        static double[] mult(double[][] a, double[] x) {
            return null;
        }

        //vector-matrix product
        static double[] mult(double[] y, double[][] a) {
            return null;
        }
    }

    private static void ex_1_1_32() {
        // plot a histogram of the count of the number in the standard input stream
        // that fall in each of the N intervals defined by dividing by (l,r) into N equal-sized intervals
        int N = 10;
        double l = 3, r = 5;
        
    }

    // pending
    private static void ex_1_1_31() {
        int N = 10;
        // between 0 and 1
        double p = 0.5;

        // plots N equally spaced dots of size .05 on the circumference of a circle
        StdDraw.setPenRadius(.05);
        for(int i = 0; i < N; i++) {
            StdDraw.circle(i, i, i);
        }

    }

    private static void ex_1_1_30() {
        // create and N-by-N boolean array a[][] such that a[i][j] is true if i and j are relatively prime
        // and false otherwise
        int N = 10;
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ( euclid(i,j) == 1) {
                    a[i][j] = true;
                }
            }
        }

        for(boolean[] row: a) {
            StdOut.println(Arrays.toString(row));
        }

    }

    // pending
    private static void ex_1_1_29() {
        int key = 3;
        int[] a = { 0,1,2,3,4,5,6 };
        // return the number of elements that are smaller than the key
        int numSmallerThanKey = rank2(key, a);
        // return the number of elements equal to the key
        int numEqualToKey = count(key, a);

        // a[i..i+j-1]
    }

    private static int rank2(int key, int[] a) {
        int i = rank(key, a);
        return a.length - i;
    }

    private static int count(int key, int[] a) {
        int i = rank(key, a);
        int j = rank(key-1, a);
        return i-j;
    }

    private static void ex_1_1_28() {
        // remove duplicate keys in whitelist after the sort
        String path = CreativeProblems.class.getResource("/11model/tinyW.txt").getPath();
        In in = new In(path);
        int[] whitelist = in.readAllInts();
        in.close();

        // sort
        Arrays.sort(whitelist);

        // remove duplicates
        int[] temp = new int[whitelist.length];
        temp[0] = whitelist[0];
        int size = 1;

        for(int i = 1; i < whitelist.length; i++) {
            if (whitelist[i-1] != whitelist[i]) {
                temp[size++] = whitelist[i];
            }
        }

        // reclaim the array
        int[] whitelist2 = new int[size];
        for(int i = 0; i < size; i++) {
            whitelist2[i] = temp[i];
        }

        StdOut.println(Arrays.toString(whitelist));
        StdOut.println(Arrays.toString(temp));
        StdOut.println(Arrays.toString(whitelist2));

    }

    private static void ex_1_1_27() {
        // binomial_error(100, 50, 0.25); // stack overflow error
        double result = binomial(100, 50, 0.25);
        StdOut.println("result : " + result);
    }

    // memoization
    private static double binomial(int N, int k, double p) {
        double[][] b = new double[N+1][k+1];

        // base cases
        for (int i = 0; i <= N; i++)
            b[i][0] = Math.pow(1.0 - p, i);
        b[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) * b[i-1][j];
            }
        }
        return b[N][k];
    }

    private static double binomial_error(int N, int k, double p) {
        if ((N == 0) && (k == 0)) return 1.0;
        if ((N < 0) && (k < 0)) return 0.0;
        return (1 - p) * binomial_error(N-1, k, p)
                + p * binomial_error(N-1, k-1, p);
    }

    private static void ex_1_1_26() {
        int a = 5;
        int b = 10;
        int c = 3;
        int t = 0;

        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }

        System.out.printf("a = %d, b = %d, c = %d", a, b, c);
    }

}
