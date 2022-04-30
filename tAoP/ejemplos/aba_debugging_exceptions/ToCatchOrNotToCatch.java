package aba_debugging_exceptions;

public class ToCatchOrNotToCatch {
    public static void main(String[] args) {
        mainA(); // => Runtime Error
        mainB(); // => Wrong Answer
    }

    public static void mainA() {
        System.exit(1);
    }

    public static void mainB() {
        try {
            int[] A = new int[2];
            System.out.println(A[10]);
        } catch (Exception e) {
        }
    }
}
