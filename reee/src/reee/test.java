package reee;
import static java.lang.System.*; 

public class test {

	public static void main(String[] args) {
		J one = new J();
		one = new J();
		one = new J();
		out.println(one);
		one = new J();
		one = new J();
		one = new J();
		one = new J();
		one = new J();
		out.println(one);

		M two = new M();
		out.println(M.count());
		two = new M();
		two = new N();
		out.println(two.fun());
		two = new N();      
		out.println(((N)two).go());
		two = new M();
		two = new N();
		out.println(two);
		out.println(N.count());

	}
	
}
