package aca_debugging_logging;

import java.io.*;
import java.util.*;

public class LoggingProgress {
    static final ArrayList<ArrayList<Integer>> allLines = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1024))) {
            if (Debug.LEVEL <= Debug.TRACE) {
                System.err.println("--- Begin reading input data ---");
            }
            while (sc.hasNextLine()) {
                String aLine = sc.nextLine();
                ArrayList<Integer> dataInLine = processLine(aLine);
                allLines.add(dataInLine);
            }
            if (Debug.LEVEL <= Debug.INFO) {
                System.err.println("allLines:");
                System.err.println(allLines);
            }
            if (Debug.LEVEL <= Debug.TRACE) {
                System.err.println("--- Begin Algorithm ---");
            }
            int i = 1; // Just for logging!!!
            for (ArrayList<Integer> line : allLines) {
                if (Debug.LEVEL <= Debug.DEBUG) {
                    System.err.println("--> Processing line " + i);
                }
                int sum = 0;
                for (Integer x : line) {
                    if (Debug.LEVEL <= Debug.TRACE) {
                        System.err.println("Sum: " + sum + " + " + x);
                    }
                    sum += x;
                    if (Debug.LEVEL <= Debug.INFO) {
                        System.err.println("Accumulated sum: " + sum);
                    }
                }
                if (Debug.LEVEL <= Debug.ERROR) {
                    System.err.println("Sum: " + sum);
                }
                System.out.println(sum);
                ++i;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
            System.exit(1);
        }
    }

    private static ArrayList<Integer> processLine(String aLine) {
        try (Scanner sc = new Scanner(aLine)) {
            ArrayList<Integer> line = new ArrayList<Integer>();
            while (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (Debug.LEVEL <= Debug.TRACE) {
                    System.err.println(number);
                }
                line.add(number);
            }
            if (Debug.LEVEL <= Debug.DEBUG) {
                System.err.println("Read line: " + line);
            }
            return line;
        } catch (Exception e) {
        }
        return null;
    }
}

final class Debug { // Since Debug class can not be extended
    final static int TRACE = 10;
    final static int DEBUG = 20;
    final static int WARNING = 30;
    final static int INFO = 40;
    final static int ERROR = 50;
    final static int OFF = 999;

    // And LEVEL is also constant => conditional compilation, not reachable
    // code will be completely removed in the bytecode program.
    // Just change the value below and compile again
    final public static int LEVEL = TRACE;
}
