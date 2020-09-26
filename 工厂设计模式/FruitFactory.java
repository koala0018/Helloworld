
public class FruitFactory {

	public static void createFruitGt(String name){
		Fruit f = null;
		if(name.equals("apple")){
			f = new Apple();
		}else if(name.equals("orange")){
			f = new Orange();
		}else if(name.equals("pear")){
			f = new Pear();
		}
		f.create();
	}
}
