public class test{
	public static void main(String[]args){
		AssassinNode test = new AssassinNode("test",null);
		AssassinNode current = test;
		for(int i=0; i<5; i++){
			current.next = new AssassinNode(i+"",null)
			current = current.next;
		}
