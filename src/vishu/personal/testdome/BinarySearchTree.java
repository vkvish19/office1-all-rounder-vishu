package vishu.personal.testdome;

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
    //    throw new UnsupportedOperationException("Waiting to be implemented.");
        if(root != null){
            if(root.value == value){
            	return true;
            }
            if(root.value > value){
            	if(root.left != null ){
            		root = root.left;
            		return contains(root, value);
            	}
            	else{
            		return false;
            	}
            }
            else{
            	if(root.right != null){
            		root = root.right;
            		return contains(root, value);
            	}
            	else{
            		return false;
            	}
            }
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        
        System.out.println(contains(n3.left, 2));
    }
}