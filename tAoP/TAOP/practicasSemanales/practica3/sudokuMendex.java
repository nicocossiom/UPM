import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class sudokuMendex {

    public static void main(String[] args) {
        Board board;
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int[][] input;
        char[] buffer = { 'a' };
        try {
            while (sc.hasNextLine()) {
                board = new Board();
                input = new int[9][9];
                buffer = new char[9];
                for (int i = 0; i < 9; i++) {
                    buffer = sc.nextLine().toCharArray();
                    for (int j = 0; j < 9; j++) {
                        if (buffer[j] == '-')
                            input[i][j] = 0;
                        else
                            input[i][j] = Character.getNumericValue(buffer[j]);
                    }
                }
                board.addInitialCells(input);
                PartialSolutionCost start = new PartialSolutionCost(board);
                bestCost(start).board.print();
                sc.nextLine();
            }
        } catch (Exception e) {
        }

    }

    private static PartialSolutionCost bestCost(PartialSolutionCost problem) {
        Stack<PartialSolutionCost> frontier = new Stack<PartialSolutionCost>();
        PartialSolutionCost current;
        frontier.push(problem);
        while (!frontier.isEmpty()) {
            current = frontier.pop();
            if (current.isValid()) {
                if (current.isFinal()) {
                    return current;
                } else {
                    ArrayList<PartialSolutionCost> succesors = current.successors();
                    Iterator<PartialSolutionCost> cursor = succesors.iterator();
                    while (cursor.hasNext()) {
                        frontier.push(cursor.next());
                    }
                }
            }
        }
        System.out.println("Error");
        return null;
    }
}

class PartialSolutionCost {

    public Board board;

    public PartialSolutionCost(Board board) {
        this.board = board;
        this.board.update();
    }

    public boolean isValid() {
        return !board.broke;
    }

    public boolean isFinal() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!board.cell_array[i][j].state)
                    return false;
            }
        }
        return true;
    }

    public ArrayList<PartialSolutionCost> successors() {
        ArrayList<PartialSolutionCost> list = new ArrayList<PartialSolutionCost>();
        for (int k = 1; k < 10 && isValid(); k++) {
            for (int i = 0; i < 9 && isValid(); i++) {
                for (int j = 0; j < 9 && isValid(); j++) {
                    int new_freedom = board.cell_array[i][j].freedom();
                    if (new_freedom == -1) {
                        board.broke = true;
                    }
                    if (!board.cell_array[i][j].state && new_freedom != -1 && new_freedom == k) {
                        for (int l = 0; l < k; l++) {
                            Board new_board = new Board(board.copyCellArray());
                            int new_posible_value = new_board.getPosibleCellValue(i, j, l);
                            if (new_posible_value == 0) {
                                System.out.println("Se ha rallao en : " + i + " " + " " + j + " " + k);
                            } else {
                                new_board.cell_array[i][j].setValue(new_posible_value);
                                PartialSolutionCost psc = new PartialSolutionCost(new_board);
                                list.add(0, psc);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}

class Board {
    Cell[][] cell_array;
    boolean broke = false;

    public Board() {
        cell_array = new Cell[9][9];
    }

    public Board(Cell[][] cell_array) {
        this.cell_array = cell_array.clone();
    }

    public void addInitialCells(int[][] input) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (input[i][j] != 0)
                    cell_array[i][j] = new Cell(input[i][j]);
                else
                    cell_array[i][j] = new Cell();
            }
        }
        update();
    }

    public int getCellValue(int x, int y) {
        return cell_array[x][y].final_value;
    }

    public void update() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                solveForCell(i, j);
            }
        }
    }

    private int getMax(int x) {
        if (x <= 2 && x >= 0)
            return 2;
        else if (x <= 5 && x >= 3)
            return 5;
        else if (x <= 8 && x >= 6)
            return 8;
        else
            System.err.println("Error: getMax: value not in acceptable range");
        return -1;
    }

    public boolean solveForCell(int x, int y) { // If the cell has a final value, it returns false
        if (cell_array[x][y].state == true)
            return false;
        else {
            int max_x = getMax(x), max_y = getMax(y), min_x = max_x - 2, min_y = max_y - 2;
            boolean[] bool_list = new boolean[9];
            for (int i = 0; i < 9; i++) {
                bool_list[i] = false;
            }
            for (int i = 0; i < 9; i++) { // Search in y branch > and later on on x branch V
                int value = getCellValue(i, y);
                if (value != 0) {
                    bool_list[value - 1] = true;
                }
                value = getCellValue(x, i);
                if (value != 0) {
                    bool_list[value - 1] = true;
                }
            }
            for (int i = min_x; i <= max_x; i++) { // Search in quadrant
                for (int j = min_y; j <= max_y; j++) {
                    int value = getCellValue(i, j);
                    if (value != 0) {
                        bool_list[value - 1] = true;
                    }
                }
            }
            if (cell_array[x][y].setPosibleValues(bool_list)) {

            } else {
                broke = false;
                return false;
            }
            if (cell_array[x][y].freedom() == 1) {
                cell_array[x][y].setValue(cell_array[x][y].getPosibleValue(0));
                updateRelatedCells(x, y);
            }
            return true;
        }
    }

    private void updateRelatedCells(int x, int y) {
        int x2 = getMax(x), x1 = x2 - 2, y2 = getMax(y), y1 = y2 - 2;
        for (int i = 0; i < 9; i++) {
            if (!(i <= x2 && i >= x1)) {
                solveForCell(x, y);
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!(i <= y2 && i >= y1)) {
                solveForCell(x, y);
            }
        }
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                solveForCell(x, y);
            }
        }
    }

    public Cell[][] copyCellArray() {
        Cell[][] ar = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cell_array[i][j].state)
                    ar[i][j] = new Cell(cell_array[i][j].final_value);
                else {
                    ar[i][j] = new Cell();
                    ar[i][j].posible_values = cell_array[i][j].posible_values.clone();
                }
            }
        }
        return ar;
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(cell_array[i][j].get());
            }
            System.out.print("\n");

        }
    }

    // public void printLog(){
    // for (int i = 0; i < 9; i++){
    // for (int j =0; j < 9; j++){
    // System.out.print(cell_array[i][j].get());
    // Sudoku9x9.log += cell_array[i][j].get(); //Debugging pourposes
    // }
    // System.out.print("\n");
    // Sudoku9x9.log += "\n"; //Debugging pourposes
    // }
    // }
    public int getPosibleCellValue(int x, int y, int number) {
        if (!cell_array[x][y].state)
            return cell_array[x][y].getPosibleValue(number);
        else
            return cell_array[x][y].final_value;
    }
}

class Cell {
    boolean[] posible_values; // True means not a posible value
    int final_value;
    int values_size;
    boolean state; // True means it has a final value

    public Cell() {
        state = false;
        final_value = 0;
        values_size = 0;
    }

    public Cell(int value) {
        posible_values = new boolean[9];
        setValue(value);
    }

    public int freedom() {
        if (values_size > 0 && !state)
            return values_size;
        else if (state)
            return 0;
        else
            return -1;
    }

    public int getPosibleValue(int number) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (!posible_values[i]) {
                if (count == number)
                    return i + 1;
                else
                    count++;
            }
        }
        return 0;
    }

    public void setValue(int value) {
        state = true;
        values_size = 1;
        final_value = value;
        for (int i = 0; i < 9; i++) {
            posible_values[i] = true;
        }
        posible_values[value - 1] = false;
    }

    public boolean setPosibleValues(boolean[] bool_list) { // Returns false if the bool_list is completely true
        int count = 0;
        int i = 0;
        while (i < 9) {
            if (bool_list[i] == false) {
                count++;
            }
            i++;
        }
        if (count == 0) {
            return false;
        } else {
            posible_values = bool_list.clone();
            updateSize();
        }
        return true;
    }

    private void updateSize() {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (posible_values[i] == false)
                count++;
        }
        values_size = count;
    }

    public int get() {

        return final_value;
    }
}