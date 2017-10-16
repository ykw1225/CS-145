public class Tester{
	public static void main(String[]args){
		int n = 4;
		int result = 1;
		for(int i = 2; n > 0; i+=2, n-=1){
			result *= i;
		}
		System.out.println(result);
	}
}