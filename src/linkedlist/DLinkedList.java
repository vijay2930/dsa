package linkedlist;

public class DLinkedList {
    protected class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this(val,null,null);
        }
        Node(int val,Node next,Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }
    private Node head,tail;
    private int length;
    DLinkedList(){
        head=null;
        tail=null;
        length=0;
    }
    public void insertFront(int val) {
        Node temp=new Node(val,this.head,null);
        if(tail==null){
            this.head=temp;
            this.tail=head;
        }else{
            head.prev=temp;
            head=temp;
        }
        this.length++;
    }
    public void insertRear(int val){
        if(length==0){
            insertFront(val);
            return;
        }
        Node temp=new Node(val,null,this.tail);
        this.tail.next=temp;
        this.tail=temp;
        this.length++;
    }

    public void print(boolean rev){
        Node temp=!rev?this.head:this.tail;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=!rev?temp.next:temp.prev;
        }
        System.out.println(null+"\n");

    }
    public void print(){
        print(false);
    }
    public void deleteFront(){
        if(length<=1){
            this.head=this.tail=null;
            this.length=0;
            return;
        }
        this.head=this.head.next;
        this.head.prev=null;
        this.length--;
    }
    public void deleteRear(){
        if(length<=1){
            deleteFront();
            return;
        }
        this.tail=this.tail.prev;
        this.tail.next=null;
        this.length--;
    }
    public void insertSpecificPosition(int val,int pos){
        if(length==0){
            insertFront(val);
            return;
        }
        if(length==pos){
            insertRear(val);
            return;
        }
        Node temp=traversal(pos-1);
        Node newNode=new Node(val,temp.next,temp);
        temp.next=newNode;
        newNode.next.prev=newNode;
        this.length++;

    }
    public void deleteSpecificPosition(int pos){
        if(length<=1){
            deleteFront();
            return;
        }
        if(length==pos){
            deleteRear();
        }
        Node prev=traversal(pos-1);
        Node next=prev.next.next;      
        prev.next=next;
        next.prev=prev;
        this.length--;
    }
    public Node traversal(int pos,boolean rev){
        Node temp=!rev ? this.head : this.tail;
        int count=0;
        while(temp!=null&&count<pos){
            temp=!rev?temp.next:temp.prev;
            count++;
        }
        return temp;
    }
    public Node traversal(int pos) {
        return traversal(pos,false);
    }
    public static void main(String[] args) {
        DLinkedList l=new DLinkedList();
        l.insertRear(0);
        l.insertRear(1);
        l.insertRear(2);
        l.insertRear(3);
        l.print();
        l.insertSpecificPosition(44, 3);
        l.print();
        l.deleteSpecificPosition(3);
        l.print();
    }
}
