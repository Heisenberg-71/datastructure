package linkedlist;


public class Main {

    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(5);
        list.insertLast(7);
        list.display();
        list.insert(6,5);
        list.display();
        System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
		list.reverseList();
        list.display();
       // System.out.println(list.find( 3));
        list.display();


       /*  DLL list=new DLL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(5);
        list.insert(4, 3);
       System.out.println(list.delete(2));
       
        list.display(); */
        CLL listCll=new CLL();
        listCll.insertFirst(3);
        listCll.insertFirst(2);
        listCll.insertFirst(1);
        listCll.insertLast(5);
        listCll.display();
        listCll.insert(4, 3);
        listCll.display();
        listCll.delete(3);
        listCll.display();
    }
}
