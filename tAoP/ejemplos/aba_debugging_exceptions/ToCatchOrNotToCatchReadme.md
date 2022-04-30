# Errors and Exception Handling

For the judge:

1) An unhandled exception is a "Runtime Error"
2) A program exiting with any value not equal to zero is a "Runtime Error"

While:

3) A program which produces any output not matching the expected output
is a "Wrong Answer"

Therefore:

a) By catching all exception in a program we can always get a "Wrong Answer"

b) Respectively, by exiting with one (or whatever number except zero) we can get
a "Runtime Error"

c) We can switch easily between these two veredicts with minimal changes in 
our code and use that to *debug*

This holds for any programming language (AFAIK: as far as I know).

How to retrieve the exit value of the program... Try typing:

---

```bash
echo $?
```

---

just after running your program (*nix terminal), in Windows command.com terminal: 

---

```
echo %ERRORLEVEL%
```

---
