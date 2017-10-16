import java.util.*;
import java.io.*;

/**
 * This class is a binary tree that contains many question and answer.
 * @author Kit Wong
 */
public class QuestionTree{

	private QuestionNode overallRoot;

	/**
	 * This is the constructor.
	 */
	public QuestionTree(){
		overallRoot = new QuestionNode();
		overallRoot.data = "computer";
	}

	/**
	 * This method is taking a txt file input and
	 * setup the binary tree with the information in the file.
	 * @param input is the txt file input that contains questions and answers.
	 */
	public void read(Scanner input){
		overallRoot = read(input, overallRoot);
	}
	private QuestionNode read(Scanner input, QuestionNode root){
		//if the file is not empty then continues
		if(input.hasNextLine()){
			//take the whole line into a string
			String line = input.nextLine();
			//just for recursive running time to initialize the new node
			root = new QuestionNode();
			//if it is a question
			if(line.equals("Q:")){
				//save next line into data
				root.data = input.nextLine();
				//use read method to create its left and right branches
				root.left = read(input, root.left);
				root.right = read(input, root.right);
			}
			//if it is an answer, just need to save the next line into data
			else{
				root.data = input.nextLine();
			}
		}
		return root;
	}

	/**
	 * This method is re-writting the txt file(because the user may add some new things).
	 * @param output is the printstream object for txt file.
	 */
	public void write(PrintStream output){
		output = write(output, overallRoot);
	}
	private PrintStream write(PrintStream output, QuestionNode root){
		//if the root is not null, then continue
		if(root != null){
			//checking if the root is a leaf node
			if(root.leaf()){
				//if it is leaf, it means root does not have branches
				output.println("A:");
				output.println(root.data);
			}
			else {
				//if it is leaf, it means root does have branches
				output.println("Q:");
				output.println(root.data);
				write(output, root.left);
				write(output, root.right);
			}
		}
		return output;
	}

	/**
	 * This method is checking if the user response yes or no to the given question
	 * and checking if the user using right input to answer the question.
	 * @param question is the given question need user to response.
	 * @return true if user say yes(y), return false if user say no(n).
	 */
	public boolean yesTo(String question){
		Scanner input = new Scanner(System.in);
		System.out.print(question + "(y/n) ");
		//deleting the spaces at the beginning and the end of the answer
		//and transform all letter to lowercase.
		String answer = input.nextLine().trim().toLowerCase();
		//checking if the answer is valid.
		while(!answer.equals("y") && !answer.equals("n")){
			System.out.println("Invalid input, please answer 'y' for yes or 'n' for no.");
			System.out.print(question + "(y/n)");
			answer = input.nextLine().trim().toLowerCase();
		}
		return answer.equals("y");
	}

	/**
	 * This method is the computer guessing the object by asking some qusetions that
	 * in the binary tree to the user until find the object. If the object is not in
	 * the binary tree, then computer will ask user to add some new information into
	 * the binary tree.
	 */
	public void askQuestions(){
		overallRoot = askQuestions(overallRoot);
	}
	private QuestionNode askQuestions(QuestionNode root){
		//checking if root is empty
		if(root != null){
			//chekcing if root is leaf
			if(root.leaf()){
				//chekcing if the object is the data in this node
				//if yes say got it right
				if(yesTo("Would your object happen to be " + root.data + "?")){
					System.out.println("Great, I got it right!");
				}
				//if no ask user to add the object name and a question about it.
				else{
					//make a temp node for saving current object
					QuestionNode temp = root;
					Scanner input = new Scanner(System.in);
					System.out.print("What is the name of your object?");
					//save the object name in the data
					String data = input.nextLine().trim();
					//make a new node for the new object
					QuestionNode newObject = new QuestionNode(data);
					System.out.println("Please give me a yes/no question that");
					System.out.println("distinguishes between your object");
					System.out.print("and mine-->");
					//save the question in the data
					data = input.nextLine().trim();
					//make a new question node to instead the current node.
					//if the answer for the object is yes, then the answer is
					//the left branch of the question, if no, then make it right branch.
					if(yesTo("And what is the answer for your object?")){
						root = new QuestionNode(data, newObject, temp);
					}
					else{
						root = new QuestionNode(data, temp, newObject);
					}
				}
			}
			//if root is not leaf, then ask the question
			//and run the left side if user answer yes, otherwise run right side
			else{
				if(yesTo(root.data)){
					root.left = askQuestions(root.left);
				}
				else{
					root.right = askQuestions(root.right);
				}
			}
		}
		return root;
	}
}