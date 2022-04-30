
# Input format

File contains integer numbers and words separated by white characters. 

We are going to *assume* the text file is organized in lines and  
that each of those lines will contain the data for an array of strings, 
but it is not necessary that these lines actually exist.

So each line consists of:

* One leading integer number greater than zero that is the number
of string in the array
  
* Followed by that number of strings

The file could have any number of such lines. 

# Program

The program stores the data in an object of type `ArrayList<String[]>` because
the number of strings per line is known in advance, but the number of lines is
undetermined (until EOF).

The program doesn't not need to read line by line since the size of the line 
and its existence can be obtained by reading the first data: the integer number. 
So we can program a loop checking the existence of the integer and then a `for` 
loop to read the content of the line. 
