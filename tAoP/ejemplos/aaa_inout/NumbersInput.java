package aaa_inout;

import java.io.*;
import java.util.*;

public class NumbersInput {

    public static void main(String[] args) {
        int[][] matrix = null;

        try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 32 * 1024))) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();

            matrix = new int[rows][cols];

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
            System.exit(1);
        }

        if (matrix != null) {
            for (int i = 0; i < matrix.length; ++i) {
                System.out.println(Arrays.toString(matrix[i]));
            }
        }
    }
}