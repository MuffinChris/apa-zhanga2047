JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Ball.java \
	BlinkyBall.java \
	Block.java \
	Collidable.java \
	InvisibleBall.java \
	Locatable.java \
	Paddle.java \
	Pong.java \
	Score.java \
	SpeedUpBall.java \
	TheGame.java \
	Wall.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class