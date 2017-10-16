public class Dog{

	protected String name;
	protected int age;
	
	public Dog (){
		name = "";
		age = 0;
	}
	
	public Dog (String name; int age){
		this.name = name;
		this.age = age;
	}
	
	public void eat (){
		System.out.println (name + ": \"Au Au Au...\"");
	}
	
	public void makeNoise (){
		System.out.println (name + ": \"Wom Wom Wom...\"");
	}
	
	public void play (){
		System.out.println (name + " is shacking the tail!");
	}
}