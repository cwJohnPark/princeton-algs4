package chapter1.dataabstraction;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StringOperations {
    public static void main(String[] args) {
//        String palindromeString = "Hannah";
//        boolean isPal = isPalindrome(palindromeString);
//        StdOut.println("is Palindrome? :" + isPal);
//
//        String filenameWithExt = "myfile.txt";
//        StdOut.println("filename extract : " + extractFilename(filenameWithExt));
//
//        printsQuery("mine");
//        createArrayOfString();
        boolean isFalse = isSorted(new String[]{"a", "c", "b"});
        boolean isTrue = isSorted(new String[]{"a", "b", "c"});
        StdOut.println(isFalse);
        StdOut.println(isTrue);
    }
    public static boolean isPalindrome(String s) {
        String sLower = s.toLowerCase();
        int N = sLower.length();
        for (int i = 0; i < N; i++) {
            if (sLower.charAt(i) != sLower.charAt(N-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static String extractFilename(String s) {
        int dot = s.indexOf(".");
        String base = s.substring(0, dot);
        String extension = s.substring(dot + 1, s.length());
        return base;
    }

    public static void printsQuery(String query) {
        while(StdIn.isEmpty() == false) {
            String s = StdIn.readLine();
            if (s.contains(query)) StdOut.println(s);
        }
    }

    public static String[] createArrayOfString() {
        String input = StdIn.readAll();
        return input.split("\\s+");
    }
    public static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i-1].compareTo(a[i]) > 0)
                return false;
        }
        return true;
    }
}
