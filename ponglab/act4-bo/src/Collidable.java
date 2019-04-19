
public interface Collidable<B> {

	boolean didCollideLeft(B obj);
	boolean didCollideRight(B obj);
	boolean didCollideTop(B obj);
	boolean didCollideBottom(B obj);
	
}
