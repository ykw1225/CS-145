import java.util.*;
public class ClassWork{

	public static void main(String[] args){

		int[] people = new int[10];
		int size = 0;

		people[0]=0;
		size++;
		people[1]=5;
		size++;
		people[2]=8;
		size++;
		//people[3]=6;
		//people[4]=9;
		System.out.println(Arrays.toString(people));
		System.out.println(Arrays.binarySearch(people,0,size,0));
		System.out.println(Arrays.binarySearch(people,0,size,-1));
		System.out.println(Arrays.binarySearch(people,0,size,1));
		System.out.println(Arrays.binarySearch(people,0,size,6));
		System.out.println(Arrays.binarySearch(people,0,size,9));
		boolean = -2;

		if(boolean){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
	}
}
