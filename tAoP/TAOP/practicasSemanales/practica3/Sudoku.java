
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Sudoku {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        Sudoku sudoku = new Sudoku(9, scanner);
        Sudoku.solve(sudoku);
        System.out.println(sudoku);

    }

    private static class Pair<X, Y> {
        public final X x;
        public final Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    private Board board;
    private int square_size;

    private final Integer[] comparision_array;

    public Sudoku(int dimension, Scanner scanner) {
        this.square_size = (int) Math.sqrt(dimension); // dimension of a square inside the sudoku
        comparision_array = new Integer[dimension]; // available numbers for a cell in the sudoku
        this.board = new Board(dimension);
        for (int i = 0; i < comparision_array.length; i++) {
            comparision_array[i] = i + 1;
        }
        int i = 0; // row counter
        int j = 0; // column counter

        // Fill the board with parsed cell values
        while (i < dimension) {
            String line = scanner.nextLine();
            for (char valor : line.toCharArray()) {
                this.board.tablero.get(i)
                        .add(new Cell(board, valor == '-' ? 0 : Character.getNumericValue(valor), i, j));
                j = j == dimension - 1 ? 0 : j + 1; // border of sudoku, reset column counter
            }
            i++;
        }
        System.out.println(this);
    }

    /**
     * Calculates all the freedom degree for each cell, and adds it to the queue, if an exception is raised then we need
     * to break branch recursion, so we return null so upstream it can be known when to do so.
     * @param sudoku
     * @return PriorityQueue<Pair<Integer, Cell>>
     */
    private static PriorityQueue<Pair<Integer, Cell>> calculatePriorities(Sudoku sudoku) {
        PriorityQueue<Sudoku.Pair<Integer, Sudoku.Cell>> freedomQueue = new PriorityQueue<Pair<Integer, Cell>>(
                new intCellComparator());
        for (List<Cell> lista : sudoku.board.tablero) {
            for (Cell celda : lista) {
                if (celda.value == 0) {
                    int freedomDegree = 0;
                    try {
                        freedomDegree = celda.freedom();
                    } catch (Exception e) {
                        return null;
                    }
                    Pair<Integer, Cell> pareja = new Pair<Integer, Cell>(freedomDegree, celda);
                    freedomQueue.add(pareja);
                }
            }
        }
        return freedomQueue;
    }

    private static class intCellComparator implements Comparator<Pair<Integer, Cell>> {
        // Comparator class used in the priority queue as we need them to be compared by their freedom degree Pair.x
        @Override
        public int compare(Sudoku.Pair<Integer, Sudoku.Cell> o1, Sudoku.Pair<Integer, Sudoku.Cell> o2) {
            return o1.x.compareTo(o2.x);
        }

    }

    /**
     * Actual solving recursive function
     * 
     * @param prioridades
     * @return boolean
     */
    public static Pair<Boolean, Sudoku> solve(Sudoku sudoku, PriorityQueue<Pair<Integer, Cell>> prioridades) {
        Boolean condition = false;
        Pair<Boolean, Sudoku> result = new Pair<Boolean, Sudoku>(false, sudoku);
        int i = 0;
        while (!condition) {
            // get and remove header of queue (one with lesser degree of freedom)
            Pair<Integer, Cell> pair = prioridades.poll();
            if (pair == null) { // base case we have found a solution as queue is empty
                return new Pair<Boolean, Sudoku>(true, sudoku);
            }
            Cell celda = pair.y;
            celda.value = celda.freedomValues[i];
            PriorityQueue<Sudoku.Pair<Integer, Sudoku.Cell>> newQueue = calculatePriorities(sudoku);
            if (newQueue == null) { // backtracking
                break; // break recursion tree branch and try again with next possible value
            }
            result = Sudoku.solve(sudoku, newQueue);
            condition = result.x; // update loop condition in case we've found a solution
        }
        return result;
    }

    /**
     * Sudoku solve function wrapper that returns true if solved, false if not
     * 
     * @param sudoku
     * @return boolean
     */
    public static boolean solve(Sudoku sudoku) {
        Pair<Boolean, Sudoku> result = Sudoku.solve(sudoku,
                (PriorityQueue<Sudoku.Pair<Integer, Sudoku.Cell>>) calculatePriorities(sudoku));
        return result.x;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return this.board.toString();
    }

    /**
     * Calculates the freedom values of a given cell by getting it's column, row and square into sets, and removing all
     * elements from the comparision array that are in said sets, hence resulting in the possible values for the cell.
     * 
     * @param celda
     * @return Integer[]
     */
    public Integer[] calculateFreedomValues(Cell celda) {
        Set<Integer> freedomSet = new HashSet<Integer>(Arrays.asList(comparision_array));
        freedomSet.removeAll(getColumnNumbers(celda)); // remove all numbers which are in cell column
        freedomSet.removeAll(getRowNumbers(celda)); // remove all numbers which are in cell row
        freedomSet.removeAll(getSquareNumbers(celda)); // remove all numbers which are in cell square
        return freedomSet.toArray(new Integer[0]); // oneliner way to return the freedomSet as an array of integers
    }

    /**
     * @param celda
     * @return Set<Integer>
     */
    private Set<Integer> getSquareNumbers(Cell celda) {
        int row = celda.row;
        int column = celda.column;
        int localBoxRow = row - row % square_size;
        int localBoxColumn = column - column % square_size;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = localBoxRow; i < localBoxRow + square_size; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + square_size; j++) {
                result.add(this.board.tablero.get(i).get(j).value);
            }
        }
        return new HashSet<Integer>(result);
    }

    /**
     * @param celda
     * @return Set<Integer>
     */
    private Set<Integer> getRowNumbers(Cell celda) {
        List<Integer> result = new ArrayList<Integer>();
        for (Cell celdaFila : board.tablero.get(celda.row)) {
            result.add(celdaFila.value);
        }
        return new HashSet<Integer>(result);
    }

    /**
     * @param celda
     * @return Set<Integer>
     */
    private Set<Integer> getColumnNumbers(Cell celda) {
        List<Integer> columna = new ArrayList<Integer>();
        for (List<Cell> lista : this.board.tablero) {
            columna.add(lista.get(celda.column).value);
        }
        return new HashSet<Integer>(columna);
    }

    public class Cell {

        private Integer[] freedomValues;
        private int value;
        private int row;
        private int column;
        Board tablero;

        public Cell(Board board, int initialValue, int row, int column) {
            this.value = initialValue;
            this.tablero = board;
            this.row = row;
            this.column = column;
        }

        /*
         * Mandatory freedom wrapper, calculates the freedom values (list of all possible values that can go into a
         * cell), exchanges the current sudoku freedom values for the result, returns the length of the result. If there
         * is a freedom value with length 0, calculated by calculateFreedomValues returning null, then the top recursion
         * branch must break as the current one can't be a solution. For that we raise an Exception
         */

        public int freedom() throws Exception {
            this.freedomValues = calculateFreedomValues(this);
            if (freedomValues.length == 0) {
                String errorString = "La celda " + this.toString() + "tiene 0 grados de libertad, abortando arbol";
                throw new Exception(errorString);
            } else {
                return freedomValues.length;
            }
        }

        @Override
        public String toString() {
            return "(" + this.row + ", " + this.column + ", Valor = " + String.valueOf(this.value) + ")";
        }

        /*
         * We need to reimplement the equals method for a cell, as we want cells to be compared by value not by
         * coordinates, i.e: Cell(1,1,2) != Cell(1,1,3), Cell(4,5,1) == Cell(1,2,1). This is for use in structures where
         * order between cells matters, as comparing cells we want them to be based on value
         */

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof Cell) {
                Cell aComparar = (Cell) obj;
                return this.value == aComparar.value;
            } else {
                return false;
            }
        }

        /*
         * It's mandatory to create a new hashCode method, this is beacause despite the equality depending on the value
         * only, the Cell object has to be uniquely identified taking all of its parameters into account: (row, col,
         * value)
         */

        @Override
        public int hashCode() {
            return ((Integer) (value * row - column)).hashCode();
        }
    }

    public class Board {

        private List<List<Cell>> tablero;
        private int size;

        public Board(int size) {
            this.size = size;
            this.tablero = new ArrayList<List<Cell>>();
            // creates an empty board
            for (int i = 0; i < size; i++) {
                this.tablero.add(new ArrayList<Cell>());
            }

        }

        @Override
        public String toString() {
            String result = "";
            for (int i = 0; i < tablero.size(); i++) {
                for (int j = 0; j < tablero.get(i).size(); j++) {
                    int valor = tablero.get(i).get(j).value;
                    result += valor == 0 ? "-" : valor;
                }
                result += "\n";
            }
            return result;
        }
    }
}