import java.util.Scanner;

public class Input {

	private Scanner scan = null;
	public Input(){
		scan = new Scanner(System.in);
	}
	public String getString(String info){
		System.out.println(info);
		return scan.nextLine();
	}
	public int getInt(String info){
		String n = getString(info);
		return Integer.parseInt(n);
	}
}
