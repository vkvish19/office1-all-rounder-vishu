package vishu.personal.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class BinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode btn1 = new BinaryTreeNode(1);
		BinaryTreeNode btn2 = new BinaryTreeNode(2);
		BinaryTreeNode btn3 = new BinaryTreeNode(3);
		BinaryTreeNode btn4 = new BinaryTreeNode(4);
		BinaryTreeNode btn5 = new BinaryTreeNode(5);
		BinaryTreeNode btn6 = new BinaryTreeNode(6);
		BinaryTreeNode btn7 = new BinaryTreeNode(7);
		
		btn1.setLeft(btn2);
		btn1.setRight(btn3);
		
		btn2.setLeft(btn4);
		btn2.setRight(btn5);
		
		btn3.setLeft(btn6);
		btn3.setRight(btn7);
		
		Integer maxDepth = BinaryTree.maximumDepth(btn1);
		System.out.println("Max-Depth of Tree is: " +maxDepth);
		
		System.out.println("\n*****************************************************************");
		System.out.println("Pre-Order Traversal Recursive:- ");
		BinaryTree.preOrderTraversalRecursive(btn1);
		
		System.out.println("\n*****************************************************************");
		System.out.println("Pre-Order Traversal Iterative:- ");
		BinaryTree.preOrderTraversalIterative(btn1);;
		
		System.out.println("\n*****************************************************************");
		System.out.println("In-Order Traversal Recursive:- ");
		BinaryTree.inOrderTraversalRecursive(btn1);
		
		System.out.println("\n*****************************************************************");
		System.out.println("Post-Order Traversal Recursive:- ");
		BinaryTree.postOrderTraversalRecursive(btn1);
		
		System.out.println("\n*****************************************************************");
		System.out.println("Level-Order Traversal Recursive:- ");
		BinaryTree.levelOrderTraversalRecursive(btn1);
		
		System.out.println("\n*****************************************************************");
		System.out.println("Level-Order Traversal Iterative:- ");
		BinaryTree.levelOrderTraversalIterative(btn1);;
	}
	
	public static int maximumDepth(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		else{
			int leftDepth = maximumDepth(root.getLeft());
			int rightDepth = maximumDepth(root.getRight());
			
			int maxDepth = (leftDepth > rightDepth) ? (leftDepth+1) : (rightDepth+1);
			
			return maxDepth;
		}
	}

	public static void preOrderTraversalRecursive(BinaryTreeNode root){
		if(root == null){
			return;
		}
		else{
			System.out.print(root.getData() +" ");
			preOrderTraversalRecursive(root.getLeft());
			preOrderTraversalRecursive(root.getRight());
		}
	}
	
	public static void preOrderTraversalIterative(BinaryTreeNode root){
		Stack<BinaryTreeNode> stack = new Stack<>();
		if(root == null){
			return;
		}
		else{
			stack.push(root);
			while(!stack.isEmpty()){
				BinaryTreeNode node = stack.pop();
				
				System.out.print(node.getData() +" ");
				
				if(node.getRight() != null){
					stack.push(node.getRight());
				}
				if(node.getLeft() != null){
					stack.push(node.getLeft());
				}
			}
		}
	}
	
	public static void inOrderTraversalRecursive(BinaryTreeNode root){
		if(root == null){
			return;
		}
		else{
			inOrderTraversalRecursive(root.getLeft());
			System.out.print(root.getData() +" ");
			inOrderTraversalRecursive(root.getRight());
		}
	}
	
	public static void postOrderTraversalRecursive(BinaryTreeNode root){
		if(root == null){
			return;
		}
		else{
			postOrderTraversalRecursive(root.getLeft());
			postOrderTraversalRecursive(root.getRight());
			System.out.print(root.getData() +" ");
		}
	}
	
	public static void levelOrderTraversalRecursive(BinaryTreeNode root){
		int heightOfTree = BinaryTree.maximumDepth(root);
		for(int i=1; i<=heightOfTree; i++){
			BinaryTree.printGivenLevel(root, i);
		}
	}
	
	public static void printGivenLevel(BinaryTreeNode root, int level){
		if(root == null){
			return;
		}
		if(level == 1){
			System.out.print(root.getData() +" ");
		}
		else if(level > 1){
			BinaryTree.printGivenLevel(root.getLeft(), level-1);
			BinaryTree.printGivenLevel(root.getRight(), level-1);
		}
	}
	
	public static void levelOrderTraversalIterative(BinaryTreeNode root){
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if(root == null){
			return;
		}
		
		queue.add(root);
		BinaryTreeNode tempNode;
		while(!queue.isEmpty()){
			
			tempNode = queue.poll();
			System.out.print(tempNode.getData() +" ");
			
			if(tempNode.getLeft() != null){
				queue.add(tempNode.getLeft());
			}
			if(tempNode.getRight() != null){
				queue.add(tempNode.getRight());
			}
		}
	}
}
