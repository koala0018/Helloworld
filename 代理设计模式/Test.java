import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Real real = new Real();
		Proxy pro = new Proxy(real, "admin", "admin");
		pro.browse();
	}

}
