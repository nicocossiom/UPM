# Exception handle selection

Java can selectively catch the exception in a try-catch sentence. 
Just adding several catch clauses with different types of exceptions
does the trick. The following rules are applied:

1) Since all exceptions are extended from the Exception class, a catch 
clause that handles the Exception class will catch all exceptions.

2) We can write our own exceptions to extend trivially Exception 
or RuntimeException just to use them to select which exception 
will pass or which exception will produce an exit code of zero.
* Extending from Exception -> managed exception (has to be declared).
* Extending from RuntimeException -> unmanaged exception (declaration 
is optional).

On the other hand:

3) We can catch an Exception just to throw an exception with another type. 

4) By dividing your code into procedures (either as a static method or not), 
you could narrow the part of your code that is getting a Runtime Error.
