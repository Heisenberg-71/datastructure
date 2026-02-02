package linkedlist;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        } else {
            Node node = new Node(value);
            node.next = null;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;

    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    public int deleteLast() {

        if (size <= 1) {
            return deleteFirst();

        }
        Node secLast = getindex(size - 2);
        int val = tail.value;
        tail = secLast;
        tail.next = null;
        size--;
        // val=tail.value;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();

        }
        if (index == size - 1) {
            return deleteLast();

        }
        Node ele = getindex(index - 1);
        int val = ele.next.value;
        ele.next = ele.next.next;
        size--;
        return val;

    }

    public Node getindex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
	public Node reverseList() {
        if(head==null || head.next==null){
            return head;
        }
        Node prev=null;
        Node cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
