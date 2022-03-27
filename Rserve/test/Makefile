JAVA=java
JAVAC=javac
JFLAGS+=-encoding utf8 -source 1.6 -target 1.6

all: test PlotDemo.class StartRserve.class

../Rserve.jar: ../../org.rosuda.REngine.REngine.jar
	$(MAKE) -C .. Rserve.jar

../../org.rosuda.REngine.REngine.jar:
	$(MAKE) -C ../.. org.rosuda.REngine.REngine.jar

test: test.class ../Rserve.jar ../../org.rosuda.REngine.REngine.jar
	$(JAVA) -cp ../Rserve.jar:../../org.rosuda.REngine.REngine.jar:. test

test.class: test.java ../Rserve.jar ../../org.rosuda.REngine.REngine.jar
	$(JAVAC) $(JFLAGS) -d . -cp ../Rserve.jar:../../org.rosuda.REngine.REngine.jar:. test.java

PlotDemo.class: PlotDemo.java ../Rserve.jar ../../org.rosuda.REngine.REngine.jar
	$(JAVAC) $(JFLAGS) -d . -cp ../Rserve.jar:../../org.rosuda.REngine.REngine.jar:. $<

PlotDemo: PlotDemo.class ../Rserve.jar ../../org.rosuda.REngine.REngine.jar
	$(JAVA) -cp ../Rserve.jar:../../org.rosuda.REngine.REngine.jar:. $@

jt: jt.class ../Rserve.jar ../../org.rosuda.REngine.REngine.jar
	$(JAVA) -cp ../Rserve.jar:../../org.rosuda.REngine.REngine.jar:. $@

jt.class: jt.java ../Rserve.jar ../../org.rosuda.REngine.REngine.jar
	$(JAVAC) $(JFLAGS) -d . -cp ../Rserve.jar:../../org.rosuda.REngine.REngine.jar:. jt.java

StartRserve.class: StartRserve.java ../Rserve.jar ../../org.rosuda.REngine.REngine.jar
	$(JAVAC) $(JFLAGS) -d . -cp ../Rserve.jar:../../org.rosuda.REngine.REngine.jar:. StartRserve.java

clean:
	rm -rf org *~ *.class

.PHONY: test all clean

