public class Cat{

	protected String name;
	protected int age;
	
	public Cat (){
		name = "";
		age = 0;
	}
	
	public Cat (String name; int age){
		this.name = name;
		this.age = age;
	}
	
	public void eat (){
		System.out.println (name + ": \"Gu Gu Gu...\"");
	}
	
	public void makeNoise (){
		System.out.println (name + ": \"Meow Meow Meow...\"");
	}
	
	public void lurk (){
		System.out.println (name + " is watching you!");
	}
}
