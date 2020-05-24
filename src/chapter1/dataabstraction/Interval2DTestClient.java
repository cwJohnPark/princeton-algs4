package chapter1.dataabstraction;

import edu.princeton.cs.algs4.*;

public class Interval2DTestClient {
    public static void main(String[] args) {

        double xlo = .2;
        double xhi = .5;
        double ylo = .5;
        double yhi = .6;
        int T = 10000;

        Interval1D xint = new Interval1D(xlo, xhi);
        Interval1D yint = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xint, yint);
        box.draw();

        Counter c = new Counter("hits");

        for (int t = 0; t < T; t++) {
            double x = StdRandom.random();
            double y = StdRandom.random();
            Point2D p = new Point2D(x,y);

            if(box.contains(p))
                c.increment();
            else
                p.draw();
        }

        StdOut.println(c);
        StdOut.printf("area = %.2f\n", box.area());

    }
}
