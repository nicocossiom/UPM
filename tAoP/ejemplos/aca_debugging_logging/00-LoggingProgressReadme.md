
# Logging

The important point in logging is printting out the progress of your
program without significant impact in your performance => conditional compilation

That means the compiler is able to find out *unreachable code* and remove it
in the compiled code.

The other goal is to keep logging sentences throughout all your developing
work. That is more important than you may think because when you find an
issue, probably a bug, you need to be sure about the scope of it. So you
need badly to know how far you have done right and that means keeping
all your messages in previous steps to be sure there is not an error
from those *correct* steps.

Besides, it is quite useful to have several levels of outputs in order to
easily activate some of them (the most important) or deactivate others
(less important).

There is an interesting feature about the outputs, all *logging*
messages are written to the *standard error stream*, that way it is
possible to separate easily the information generated for debugging.

Finally, there might be some property you can check during the execution
of your program, using some not trivial routine, you can use that
conditional compilation to remove it in your final program by adjusting
the level, just in the same manner as the logging outputs.

A final note on the NIH (not invented here) syndrome, also known as
*reinventing the wheel*. Of course, there is java.util.logging package,
and that (or other similar alternatives) should be your prefered option
for logging in any other circumstances...

But, for the online judge it may be not necessary (or a good idea) to
use it because: it needs some configuration work, it has a little learning
curve and, finally, it might interfere with the program that assess
the codes. Besides, the package is usually disable since it can be
used to send messages out of the server.
