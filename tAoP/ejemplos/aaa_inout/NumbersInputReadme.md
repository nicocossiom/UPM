
# Input format

File contains integer numbers eventually separated by any number of 
white characters (spaces, tabs or newlines).

The meaning of the integer is as follows:

* First two integer numbers are the number of rows and columns 
of a matrix of integer numbers

* Rest of the numbers are the elements of the matrix row-major order 
(first number correspond to first row, then the second and so on)

# Program

The program stores the data in an object of type `int[][]` and outputs
the data (for correctness checking). You should pay attention to:

* Exception handling using try with resources 
* The BufferedInputStream for improving input reading performance 
