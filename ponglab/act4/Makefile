JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Ball.java \
	Block.java \
	Collidable.java \
	Locatable.java \
	Paddle.java \
	Pong.java \
	Score.java \
	TheGame.java \
	Wall.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class