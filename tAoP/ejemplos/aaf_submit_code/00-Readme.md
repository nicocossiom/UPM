
# About submitting code

When submitting code to an online judge, it is important
to pay attention to any rules that are imposed on the submission.

For example, in UVa, it is possible to submit only one file, it
has a size limit, and regarding to Java the file must include
a Main class with the main method and should not be public
and should not be part of any package.

These rules are public, for instance, in UVa, they are published at:

https://onlinejudge.org/index.php?option=com_content&task=view&id=15&Itemid=30

Given that... There are a lot of interesting language features that
are not forbidden and in consequence, they are allowed.

For instance, one of the points of writing Java code is, of course,
OOP, but Java needs one file per class... Well this is false,
we can put any number of classes inside a Java source file,
they can not be `public`, but that is a minor issue. In this case,
Should we program all our classes in one file? Actually, we can
write our code as usual and, then, process our code files in order
to produce the expected file for submission.

The key idea will be to use cli tools to produce the resulting
file. These tools will be: `cat`, `grep` and `sed`.

The `cat` command  is used to output the content of a
file to the standard output stream, the interesting thing
is that it can accept several files as arguments. That way
it is possible to combine two files in one file.

The `grep` command could be used to get rid of the lines
containing the package declaration or any other line including
a *particular* mark in it (could be a specific comment).

The `sed` command could be used to remove the `public`
declarations of classes or to replace any other token in the
code, for example, a logging level.

These are some examples of use (step by step):

```bash
cat ElProblema.java MisDatos.java > Submission1.java
cat Submission1.java | grep -v import | grep -v package > Submission2.java
cat Submission2.java | sed -e 's/public class ElProblema/class Main/' > Submission3.java
```
