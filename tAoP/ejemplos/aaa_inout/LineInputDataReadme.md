# Input format

File contains pairs of integer numbers and words separated by white characters.
That is each number is followed by a word related to it.

We are going to *assume* the text file is organized in lines and  
that each of those lines contains an undetermined number of pairs of data
(number, word), besides the file has an undetermined number of
lines.

# Program

The program has two classes, a trivial class, `MyData`, to store the data, the pairs
(number, word) and the main class.

The program stores the data in an object of type `ArrayList<ArrayList<MyData>` because
both the number of pairs and the number of lines are undetermined, the first `ArrayList`
will hold the lines (one element in the list per line), the nested `ArrayList` will hold the
pairs in each line.

The program reads the data in two steps (or levels). In the first steps it reads the lines,
each line is read as a whole without separating the tokens in the line. The second step
is used to parse the line and extract each token, number and words until the end of line.

The interesting thing is that both readings are done with the Scanner class, of course,
two distinct objects of Scanner are used, but that is not a problem.
