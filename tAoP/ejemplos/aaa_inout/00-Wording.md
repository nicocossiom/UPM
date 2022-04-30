# Read from standard input

## Introduction

This folder has some examples to read data from
text files that are redirected to the standard
input stream.

Once compiled each program could be executed
using the plain text file with the same name
for input data. For instance (bash terminal):

---

```bash
javac aaa_inout/NumbersInput.java
cat aaa_inout/NumbersInputData.txt | java aaa_inout.NumbersInput
```

---

The first command compiles the program, the second command
outputs the content of the txt file and, through the pipeline,
inputs the data to the java program.

The examples in increasingly difficult order are: Numbers, Words
and Line.

## Remarks

All examples use the classes `BufferedInputStream` and `Scanner`,
the first one is used to provide reading speed, the second provides
an easy way to parse tokens in the input.

It is important to note that both classes throw exceptions and are
*resources* classes, that is, their objects need to be **closed**.
That is the reason to use *try with resources*, an alternative form
to the `try` syntax with `close` in the `finally` clause. 