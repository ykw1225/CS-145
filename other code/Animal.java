public class Animal{

	protected String name;
	protected int age;
	
	public Animal (){
		name = "";
		age = 0;
	}
	
	public Animal (String name; int age){
		this.name = name;
		this.age = age;
	}
	
	public void eat (){
		System.out.println (name + ": \"Gu Gu Gu...\"");
	}
	
	public void makeNoise (){
		System.out.println (name + ": \"Meow Meow Meow...\"");
	}
}