package chapter1.programmingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.math.BigDecimal;
import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        //ex_1_1_1();
        //ex_1_1_2();
        //ex_1_1_3();
        //ex_1_1_4();
        //ex_1_1_5();
        //ex_1_1_6();
        //ex_1_1_7();
        //ex_1_1_8();
        //ex_1_1_9();
        //ex_1_1_10();
        //ex_1_1_11();
        //ex_1_1_12();
        //ex_1_1_13();
        //ex_1_1_14();
        //ex_1_1_15();
        //ex_1_1_16();
        //ex_1_1_17();
        //ex_1_1_18();
        //ex_1_1_19();
        //ex_1_1_20();
        //ex_1_1_21();
        //ex_1_1_22();
        //ex_1_1_24();

    }

    private static void ex_1_1_24() {
//        StdOut.print("Enter value p");
//        int p =StdIn.readInt();
//        StdOut.print("Enter value q");
//        int q = StdIn.readInt();
        int p = 1071;
        int q = 462;
        p = 1111111;
        q = 1234567;
        int gcd = euclid(p, q);
        StdOut.println("GCD :" + gcd);
    }

    public static int euclid(int p, int q) {
        if(q == 0 || p == 0) return 0;
        if(p % q == 0) return q;
        return euclid(q, p % q);
    }

    private static void ex_1_1_22() {
        int keyIndex = rank(3, new int[]{1,2,3,4,5,6,7,8,9,10});
    }

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length-1;
        int indentDepth = 0;
        while(lo <= hi) {
            for(int i = 0; i < indentDepth; i++) {
                StdOut.print("\t");
            }
            indentDepth++;
            StdOut.printf("ㄴㅡ ");
            StdOut.printf("lo : %s, hi: %s\n", lo, hi);

            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    private static void ex_1_1_21() {
        StdOut.print("Enter the number of Students: ");
        int numOfRows = StdIn.readInt();
        String[] names = new String[numOfRows];
        int[] col1 = new int[numOfRows];
        int[] col2 = new int[numOfRows];

        for(int i = 0; i < numOfRows; i++) {
            StdOut.print("Enter the student name: ");
            names[i] = StdIn.readString();
            StdOut.print("Enter the student score 1: ");
            col1[i] = StdIn.readInt();
            StdOut.print("Enter the student score 2: ");
            col2[i] = StdIn.readInt();
        }

        for(int i = 0; i < numOfRows; i++) {
            double avg = (col1[i] + col2[i]) / 2.0;
            StdOut.printf("name : %s, grade: %.2f\n", names[i], avg);

        }
    }

    private static void ex_1_1_20() {
        // write recursive static method compute value of ln(N!)
        int N = 4;
        double res = lnfact(N);
        StdOut.println(res);
    }

    private static double lnfact(int N) {
        long result = 1;
        for(int i = 1; i <= N; i++) {
            result *= i;
        }
        return Math.log(result);
    }

    private static void ex_1_1_19() {
//        for(int N = 0; N < 100; N++ ) {
//            System.out.println(N + " " + fibonacci(N));
//        }
        for(int N = 0; N < 100; N++ ) {
            System.out.println(N + " " + fiboBetter(N));
        }
    }

    private static BigDecimal fiboBetter(int N) {
        BigDecimal i1 = BigDecimal.valueOf(0);
        BigDecimal i2 = BigDecimal.valueOf(1);
        BigDecimal sum = BigDecimal.valueOf(0);
        while(N-- > 0) {
            sum = i1.add(i2);
            i1 = i2;
            i2 = sum;
        }
        return i1;
    }

    private static long fibonacci(int N) {
        if ( N == 0 ) return 0;
        if ( N == 1 ) return 1;
        return fibonacci(N-1) + fibonacci(N-2);
    }


    private static void ex_1_1_18() {
        int n1 = mystery(2, 25);
        StdOut.println(n1);
        int n2 = mystery(3, 11);
        StdOut.println(n2);
        int n3 = mysteryMultiply(2, 25);
        StdOut.println(n3);
        int n4 = mysteryMultiply(3, 11);
        StdOut.println(n4);
    }

    private static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    private static int mysteryMultiply(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) * a;
    }

    private static void ex_1_1_17() {
        String s1 = exR2(6);
        StdOut.println(s1);

    }

    private static String exR2(int n) {
        // change the order of these lines
        //String s = exR2(n-3) + n + exR2(n-2) + n;

        if (n <= 0) return "";
        String s = exR2(n-3) + n + exR2(n-2) + n;

        return s;
    }

    private static void ex_1_1_16() {
        String result = exR1(6);
        StdOut.println(result);
    }

    private static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    private static void ex_1_1_15() {
        int M = 10; // the size of the returned array
        // the element of the a must be between 0 to M-1
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] histogram = histogram(a, M);
        StdOut.println(Arrays.toString(histogram));
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    private static int[] histogram(int[] a, int M) {
        int[] histogram = new int[M];
        for(int i = 0; i < a.length; i++) {
            histogram[a[i]]++;
        }
        return histogram;
    }

    private static void ex_1_1_14() {
        // int value N as an argument
        // return largest int not larger than the base-2 logarithm of N.
        // DO NOT USE java.lang.Math library
        assert 0 == lg(1);
        assert 1 == lg(2);
        assert 5 == lg(32);
        assert 6 == lg(33);
        assert 10 == lg(1024);
        assert 11 == lg(1025);

    }

    private static int lg(int n) {
        int largest = 0;
        for (int i = 1; i < n; i*=2) {
            largest++;
        }
        StdOut.println(largest);
        return largest;
    }

    private static void ex_1_1_13() {
        // transposition of two-dimensional array with M rows and N columns
        int[][] a = {{1, 2, 3, 4, 5},
                    { 6, 7, 8, 9, 10},
                    { 11, 12, 13, 14, 15}};

        int[][] transposed = new int[a[0].length][a.length];

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                transposed[j][i] = a[i][j];
            }
        }

        // print the transposed array
        for(int[] row : transposed) {
            for(int num : row) {
                StdOut.print(num + " ");
            }
            StdOut.println();
        }

    }

    private static void ex_1_1_12() {

        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i ;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }

    }

    private static void ex_1_1_11() {
        // prints the contents of a two-dimensional boolean array.
        // using * to represent true and a space to represent false
        boolean[][] a = { {true, true, false, false, true},
                        { true, false, true, false, true},
                        { true, false, false, true, true}};

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                StdOut.print(a[i][j] ? "*" : " ");
            }
            StdOut.println("");
        }
    }

    private static void ex_1_1_10() {
        // what is wrong with this code.
        //int[] a;

        int[] a = new int[10]; // it must be initialized
        for (int i = 0; i < 10; i++) {
            a[i] = i * i;
        }
    }

    private static void ex_1_1_9() {
        // binary representation of a positive integer N into a String s.
        int input = 1024;
        String expected = "10000000000";

        String binary = "";
        for(int n = input; n != 0; n /= 2) {
            binary = (n % 2) + binary;
        }
        StdOut.println(binary);
        assert binary.equals(expected);

        // easy solution
        //Integer.toBinaryString();
    }

    private static void ex_1_1_8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    private static void ex_1_1_7() {
        // a
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.println("a");
        StdOut.printf("%.5f\n", t);

        // b
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < 1; j++)
                sum++;
        StdOut.println("b");
        StdOut.println(sum);

        // c
        sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println("c");
        StdOut.println(sum);
    }

    private static void ex_1_1_6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    private static void ex_1_1_5() {
        // print "true" if the double variable x and y are both strictly between 0 and 1
        // otherwise, "false"
        double x = 0.1111;
        // double x= 1; false
        double y = 0.9999;
        if ((x > 0 && x < 1) && (y > 0 && y < 1)) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }

    }

    private static void ex_1_1_4() {
        int a = 0, b = 0, c = 0;

        // a - wrong
        // if (a > b) then c = 0;
        if(a > b) { c = 0; }

        // b - wrong
        //if a > b { c = 0; }
        if (a > b) { c = 0; }

        // c - right
        if (a > b) c = 0;

        // d - right
        if (a > b) c = 0; else b = 0;
    }

    public static void ex_1_1_3() {
        // write a program that takes three integer from command-line argument
        // and prints equal if all three are equal, and not equal otherwise.
        int[] reads = new int[3];
        boolean areAllEqual = false;

        for(int i = 0; i < 3; i++) {
            int readInt = StdIn.readInt();
            reads[i] = readInt;

            // check if read integer is equal to prior integer of the array
            if(i > 0) {
                areAllEqual = readInt == reads[i - 1] ? true : false;
            }
        }

        StdOut.println("Reads : " + Arrays.toString(reads));
        StdOut.println("Are All Equal ? :" + areAllEqual);
    }

    public static void ex_1_1_2() {
        double a = (1 + 2.236) / 2;
        double guessA = 1.618;
        StdOut.println(a);
        assert guessA == a;

        double b = 1 + 2 + 3 + 4.0;
        double guessB = 10.0;
        StdOut.println(b);
        assert guessB == b;

        boolean c = 4.1 >= 4;
        boolean guessC = true;
        StdOut.println(c);
        assert guessC == c;

        String d = 1 + 2 + "3";
        String guessD = "33";
        StdOut.println(d);
        assert guessD == d;
    }

    public static void ex_1_1_1() {
        int a = ( 0 + 15) / 2;
        int guessA = 7;
        StdOut.println(( 0 + 15) / 2);
        assert guessA == a;

        double b = (2.0e-6 * 10000000.1);
        double guessB = 20.0000002;
        StdOut.println(b);
        assert guessB == b;

        boolean c = true && false || true && true;
        boolean guessC = true;
        StdOut.println(guessC);
        assert  guessC = c;

    }

}
