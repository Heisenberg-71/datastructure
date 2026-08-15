package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Node{
    Node right;
    Node left;
    int data;
    Node(int data){
        this.data=data;
    }
}
public class DaimeterOfTree {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int e=4;
        Node root=null;
        HashMap<Integer,Node> m=new HashMap<>();
        HashSet<Integer> child=new HashSet<>();
        while(e-->0){
            int p=s.nextInt();
            int c=s.nextInt();
            m.putIfAbsent(p,new Node(p));
            m.putIfAbsent(c,new Node(c));

            Node parent=m.get(p);
            Node ch=m.get(c);
            if(parent.left==null){
                parent.left=ch;
            }else{
                parent.right=ch;
            }
            child.add(c);
        }
        for(int a:m.keySet()){
            if(!child.contains(a)){
                root=m.get(a);
                break;
            }
        }
        System.out.println(diameterOfTree(root));
    }
    static int res=0;
    private static int diameterOfTree(Node root) {
        if(root==null){
            return 0;
        }
        int l=diameterOfTree(root.left);
        int r=diameterOfTree(root.right);
        res=Math.max(res,l+r);

        return 1+Math.max(l,r);
    }

    private static void preorder(Node root) {
        if(root!=null){
            preorder(root.left);
            preorder(root.right);
            System.out.println(root.data);
        }
    }
}
