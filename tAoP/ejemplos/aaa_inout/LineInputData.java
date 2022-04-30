package aaa_inout;

import java.io.*;
import java.util.*;

public class LineInputData {
    public static void main(final String[] args) {
        final ArrayList<ArrayList<MyData>> allLines = new ArrayList<ArrayList<MyData>>();

        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 4 * 1024))) {
            while (sc.hasNextLine()) {
                String aLine = sc.nextLine();
                ArrayList<MyData> dataInLine = processLine(aLine);
                allLines.add(dataInLine);
            }
        } catch (final Exception e) {
            e.printStackTrace();
            System.err.println(e);
            System.exit(1);
        }
        System.out.println(allLines);
    }

    private static ArrayList<MyData> processLine(String aLine) {
        ArrayList<MyData> dataInLine = new ArrayList<>();
        try (Scanner sc = new Scanner(aLine) ){
            while ( sc.hasNextInt() ) {
                MyData myData = new MyData();
                myData.number = sc.nextInt();
                myData.str = sc.next();
                dataInLine.add(myData);
            }
        }
        catch( final Exception e ){
            e.printStackTrace();
            System.err.println(e);
            System.exit(0);
        }
        return dataInLine;
    }
}

class MyData {
    public int number;
    public String str;

    public String toString() {
        return "(" + number + ", " + str + ")";
    }
}