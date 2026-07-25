package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinarySearchTree{
	class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	private Node root;
	BinarySearchTree(){
		this.root=null;
	}
	public void insert(int val){
		root=insertRec(root,val);
	}
	public Node insertRec(Node root,int val){
		if(root==null){
			root=new Node(val);
			return root;
		}
		if(val<root.data){
			root.left=insertRec(root.left,val);
		}
		else{
			root.right=insertRec(root.right,val);
		}
		return root;
	}
	public void preorder(){
		preorderRec(root);	
		System.out.println();
	}
	public void preorderRec(Node root){
		if(root==null){
			return;
		}
		System.out.print(root.data+" ");
		preorderRec(root.left);
		preorderRec(root.right);
	}
	public void postorder(){
		postorderRec(root);	
		System.out.println();
	}
	public void postorderRec(Node root){
		if(root==null){
			return;
		}
		
		postorderRec(root.left);
		postorderRec(root.right);
		System.out.print(root.data+" ");
	}
	public void inorder(){
		inorderRec(root);	
		System.out.println();
	}
	public void inorderRec(Node root){
		if(root==null){
			return;
		}
	
		inorderRec(root.left);
			System.out.print(root.data+" ");
		inorderRec(root.right);
	}
    public void rightView(){
        List<Integer> list=rightViewRec(root);
        System.out.println(list);
    }

    private List<Integer> rightViewRec(Node root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            Integer prev=null;
            for(int i=0;i<size;i++){
                Node node=q.poll();
                prev=node.data;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            list.add(prev);
        }
        return list;
    }
    public void leftView(){
        List<Integer> list=leftViewRec(root);
        System.out.println(list);
    }

    private List<Integer> leftViewRec(Node root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            Integer prev=null;
            for(int i=0;i<size;i++){
                Node node=q.poll();
                prev=node.data;
                if(node.right!=null) q.add(node.right);
                if(node.left!=null) q.add(node.left);
            }
            list.add(prev);
        }
        return list;
    }
}