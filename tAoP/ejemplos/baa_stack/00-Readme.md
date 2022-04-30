
# Comparing Stacks

**"Not all stacks are the same"**

Lot of algorithms need a stack in their implementation. The stack is 
an abstract data type, that is, the stack provides an interface that 
is supposed to work by means of some inner specific implementation
hidden to the programmer. That hidden implementation is not neutral 
with respect to performance.

We are going to check this performance by solving some proposed 
problems with different options and approaches.

## Problem 1 (Random number in a stack, not from any web site)

You are required to implement a program that reads some integer
numbers from the standard input, generates random numbers, stores
them into a stack and retrieves them to multiply or divide them 
to a number.

The input consist of several lines, in each line:

* A plus (`+`) or minus (`-`) symbol
* An even positive integer

The program must initialize a double variable, called result, 
to one, then, it must read each line and after reading the line it must:

* Store in the stack the given number of random real numbers 
between 1 and 2, if the symbol was (`+`)

* Retrieve the given number of number from the stack and, 
alternatively, multiply or divide it from the result 
variable, if the symbol was (`-`).

* Print out the result variable.

Write two solutions: one of them using the `LinkedList` class 
for the stack, use an array in the other one, you may suppose that
the stack will not have more than 100 000 elements at any time.

Then measure the execution time for both programs. Use the `time` command in bash or
`Measure-Command` in PowerShell:

https://man7.org/linux/man-pages/man1/time.1.html

https://docs.microsoft.com/en-us/powershell/module/microsoft.powershell.utility/measure-command?view=powershell-7.1

Notes: 

1. Use always the same random seed to check results. 
1. Result should be approximately equal to 1 after 
processing a large amount of numbers.
1. You can use the input data files in this folder.

## Problem 2 (Intersection of two lists from LeetCode)

The problem can be found here:

https://leetcode.com/problems/intersection-of-two-linked-lists/

There is a *trivial* solution for this problem using 2 stacks... Can you program it?

But, since we are interested in comparing stacks, we are going to impose some
restrictions in the implementation of the solutions, they are:

* You must write a method:
```
Deque<ListNode> doStack(ListNode head)
```
To transform the lists into the stack. Note that `Deque` is a java interface
for both stack and queue. The methods you will need from the stack are:
`size`, `peek` and `pop`.
* You must write your solution using the following classes that implement
the `Deque` interface: `ArrayDeque` and `LinkedList`
* There is also another stack: `java.util.Stack<E>` (which it is *not recommend*).
This class has the same interface, except it has an `empty` method instead of
the `size` method. Use it too, you will need to change the method declaration.

And compare the resulting times...

BTW (is there any better solution?)

## Problem 3 Reversing a linked list

This is an interesting problem in order to understand the relationship
between recursion and stack.

The problem is stated as: "Given a singly linked list, return the reversed list.
That is the list ordered from last to first". This is a common problem that can
be found at LeetCode in:

https://leetcode.com/problems/reverse-linked-list/

Your goal is to solve the problem, but also to improve your understanding
of recursion and stacks. So, instead of jumping directly into LeetCode, first
try to solve it by your own means with lot of logging messages and using
these approaches:

1) Using a stack to reverse the list (trivial, isn't it?)
2) Using recursion (this is a very elegant solution, isn't it?)
3) Using an iterative approach.

Give it some afterthought.

BTW: there is an slight more difficult problem at LeetCode:

https://leetcode.com/problems/reverse-linked-list-ii/

It might be worth a try...