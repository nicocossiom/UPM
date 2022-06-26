
JFLAGS = -d out -cp ./src
JFLAGS2 = -cp ./out
JC = javac
JVM= java
FILE=

.SUFFIXES: .java .class


.java.class:
	$(JC) $(JFLAGS) ./src/*.java

MAIN_S = Banco
MAIN_C = TPV
compile:  .java.class

startBanco: ./out/$(MAIN_S).class
	$(JVM) $(JFLAGS2) $(MAIN_S)

launchTPV: ./out/$(MAIN_C).class
	$(JVM) $(JFLAGS2) $(MAIN_C)

startBancoExtra: ./out/$(MAIN_S).class
	$(JVM) $(JFLAGS2) $(MAIN_S) extra

general:
	tmux new-session \; send-keys 'make startBanco' C-m \; split-window -h\; send-keys 'make launchTPV' C-m \; attach
extra:
	tmux new-session \; send-keys 'make startBancoExtra' C-m \; split-window -h\; send-keys 'make launchTPV' C-m \; attach

clean:
	rm -rf ./out/