import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class BinaryTree {
	public BTNode root;
	public int height;
	int data = 1;
	
	public BinaryTree(BTNode root,int height){
		this.root = root;
		this.height	= height;
		populateTree(root,1);
		
	}
	
	public void printTree(){
		printTree(root);
	}
	
	public void levelPrint(){
		levelPrint(root);
	}
	
	private void populateTree(BTNode root, int level) {
		if (level < height) {
			insertNodes(root);
			populateTree(root.left, level + 1);
			populateTree(root.right, level + 1);
		}
	}

	private void insertNodes(BTNode root) {
		root.left = new BTNode(data++, null, null);
		root.right = new BTNode(data++, null, null);
	}

	private void printTree(BTNode root) {
		if (root != null) {
			System.out.println(root.data);
			printTree(root.left);
			printTree(root.right);
		}

	}
   /**
    * Prints a binary tree in level order traversal.
    * @param root
    */
	private void levelPrint(BTNode root) {
		BTNode temp;
		Queue<BTNode> queue = new ArrayBlockingQueue<BTNode>(50);
		queue.add(root);
		while (!queue.isEmpty()) {
			Iterator<BTNode> qi = queue.iterator();
			int size = queue.size();
			int i = 0;
			Integer.toString(i);
			while (i < size) {
				temp = queue.remove();
				System.out.print(" "+ Integer.toString(temp.data) + " ");
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
				i++;
			}
			System.out.println("");

		}

	}
	/**
	 * Finds summation of all leaf nodes
	 * @param root
	 * @return
	 */
	public int sumLeaves(BTNode root){
		if(root.left == null && root.right == null) return root.data;
		else return sumLeaves(root.left) + sumLeaves(root.right);
	}
	/**
	 * Find if a tree is subtree or not
	 * @return
	 */
	public boolean isSubTree(BTNode T1, BTNode T2){
		if(T1 == T2) return true;
		else if(T1.left != null || T1.right !=null) return (isSubTree(T1.left,T2) || isSubTree(T1.right,T2));
		else return false;
	}

}
