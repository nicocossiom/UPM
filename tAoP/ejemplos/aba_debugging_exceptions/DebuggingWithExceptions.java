package aba_debugging_exceptions;

import java.io.BufferedInputStream;
import java.util.*;

public class DebuggingWithExceptions {
    public static void main(String[] args) {
        try ( Scanner sc = new Scanner(new BufferedInputStream(System.in, 4*1024))) {
            InputData data = new InputData();
            // Throws MyExceptionOne
            data.read(sc);

            AnAlgorithm alg = new AnAlgorithm();

            // Throws MyExceptionTwo
            int[] intermediateResult = alg.solve(data);

            // Throws MyExceptionThree
            int res = computeSum(intermediateResult);

            System.out.println(res);
        } catch (MyExceptionOne e) {
            e.printStackTrace();
            System.out.println(e);
            // If exit(1) then you will get "runtime error"
            // else if exit(0) then you will get "wrong answer"
            System.exit(1); 
        } catch (MyExceptionTwo e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(1);
        } catch (MyExceptionThree e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(1);
        }
    }

    // It declares explicitly that it throws MyExceptionThree (it is optional)
    private static int computeSum(int[] v) throws MyExceptionThree {
        // Surround everything with the "try"
        try {
            int sum = 0;
            for ( int i = 0; i <= v.length; ++i ) {
                sum += v[i];
            }
            return sum;
        } catch ( Exception e ) {
            throw new MyExceptionThree();
        }
    }
}

class InputData {
    // Some input data
    ArrayList<Integer> numbers = new ArrayList<>();
    
    void read(Scanner sc) {
        try {
            while ( sc.hasNextInt() ) {
                int n = sc.nextInt();
                System.out.println(n);
                numbers.add(n);
            }    
        } catch ( Exception e ) {
            throw new MyExceptionOne();
        }
    }
}

class AnAlgorithm {

    // Throws MyExceptionTwo declaration is mandatory as it is not a RuntimeException
    public int[] solve(InputData data) throws MyExceptionTwo {
        try {
            int[] diff = new int[data.numbers.size()-1];
            for ( int i = 0; i < data.numbers.size(); ++i) {
                diff[i] = data.numbers.get(i+1) - data.numbers.get(i);
            } 
            return diff;
        } catch (Exception e) {
            throw new MyExceptionTwo();
        }
    }
}

// By extendint RuntimeException declaring throwing is optional
// If you replace RuntimeException with Exception, you will need 
// to declare that the method explicit throw that exception
class MyExceptionOne extends RuntimeException {}

class MyExceptionTwo extends Exception {}

class MyExceptionThree extends RuntimeException {}
