/**
 * This class is a question node which has a string data and two pointer that left and
 * right (left to yes, right to no) pointing to two other question nodes.
 * @author Kit Wong
 */
public class QuestionNode{

	public String data;
	public QuestionNode left;
	public QuestionNode right;

	/**
	 * This is the constructor.
	 * @param data is the a string object that is either a question or an answer.
	 * @param left is the other node connect by left pointer.
	 * @param right is the other node connect by right pointer.
	 */
	public QuestionNode(String data, QuestionNode left, QuestionNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * Also the constructor but only given a string.
	 * @param data is the given string need to save.
	 */
	public QuestionNode(String data){
		this(data,null,null);
	}

	/**
	 * Another constructor without given information.
	 */
	public QuestionNode(){
		this(null,null,null);
	}

	/**
	 * This method is checking if the node is a leaf node whose left and right are null.
	 * @return true if node is leaf, otherwise return false.
	 */
	public boolean leaf(){
		if(left == null && right == null){
			return true;
		}
		return false;
	}
}