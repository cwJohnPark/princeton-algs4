package chapter1.programmingmodel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length-1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    /**
     * whitelist using BinarySearch
     */
    public static void main(String[] args) {

        // read the integers from a file
        String path = BinarySearch.class.getResource("/11model/tinyW.txt").getPath();
        In in = new In(path);
        int[] whitelist = in.readAllInts();
        in.close();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        String path2 = BinarySearch.class.getResource("/11model/tinyT.txt").getPath();
        In tinyT = new In(path2);
        while(!tinyT.isEmpty()) {
            int key = tinyT.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
        tinyT.close();
    }
}
