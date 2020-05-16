package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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
        ex_1_1_14();
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
