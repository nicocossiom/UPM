package aaa_inout;

import java.io.*;
import java.util.*;

public class WordsInputData {

    public static void main(String[] args) {
        ArrayList<String[]> words = new ArrayList<>();
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 4*1024))) {
            while (sc.hasNextInt() ) {
                int numberOf = sc.nextInt();
                String[] line = new String[numberOf];
                for ( int j = 0; j < numberOf; ++j ) {
                    line[j] = sc.next();
                }
                words.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
            System.exit(1);
        }

        for ( String[] line : words) {
            System.out.println(Arrays.toString(line));
        }
    }
}