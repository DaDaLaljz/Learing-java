package simpleFactory;

public class ClamPizza extends Pizza{

	public void prepare(){
		System.out.println("Prepare ClamPizza.");
	}
	
	public void cut(){
		System.out.println("Cut ClamPizza.");
	}
	
	public void bake(){
		System.out.println("Bake ClamPizza.");
	}
	
	public void box(){
		System.out.println("Box ClamPizza.");
	}
	
}
