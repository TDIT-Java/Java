package Pradeep.CodingTests.Java8;

import java.util.stream.*;
import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

public class IntervalsFindTheTotalCoveredLength {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 4),
                new Interval(2, 6)
        );

        int totalCoveredLength = intervals.stream().
                mapToInt(interval -> interval.getEnd() - interval.getStart()).
                sum();
        System.out.println("Total covered length: " + totalCoveredLength);

    }
}
