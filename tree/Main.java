package tree;
public class Main{
	public static void main(String args[]){
		BinarySearchTree b = new BinarySearchTree();
        b.insert(5);
        b.insert(3);
        b.insert(10);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(15);
		b.preorder();
	    b.rightView();
        b.leftView();
	}
}