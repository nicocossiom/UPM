
JFLAGS = -cp ../lib/librerias/*:.
JC = javac
JVM= java
FILE=

.SUFFIXES: .java .class


.java.class:
	$(JC) $(JFLAGS) *.java

MAIN_S = Banco
MAIN_C = TPV

default: .java.class
run_s: $(MAIN_S).class
	$(JVM) $(JFLAGS) $(MAIN_S)

run_r: $(MAIN_C).class
	$(JVM) $(JFLAGS) $(MAIN_C) $(ID)

clean:
	$(RM) *.class
