package linkedlist;

public class SLinkedList {
    
    protected class Node{
        int val;
        Node next;
        Node(int val){
            this(val,null);
        }
        Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
    private Node head;  
    private Node tail;
    private int length;
    SLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
    public void insertFront(int val){
        this.head=new Node(val,this.head);
        if(this.tail==null){
            this.tail=this.head;
        }
        this.length++;
    }
    public void insertRear(int val) {
        if(tail==null){
            insertFront(val);
            return;
        }
        this.tail.next=new Node(val,null);
        tail=tail.next;
        this.length++;
    }
    public void insertSpecificPosition(int val,int pos){
        if(pos==0){
            insertFront(val);
            return;
        }
        if(pos==this.length){
            insertRear(val);
            return;
        }
        Node prevNode=traversal(pos-1);
        prevNode.next=new Node(val,prevNode.next);
        this.length++;
    }
    public void deleteFront(){
        if(this.head==null){
            System.out.println("List is empty");
            return;
        }
        if(this.length==1)
            this.head=this.tail=null;
        else
            this.head=this.head.next;
        this.length--;
    }

    public Node traversal(int pos){
        int count=0;
        Node temp=this.head;
        while(count<pos){
            temp=temp.next;
            count++;
        }
        return temp;
    }
    public void print(){
        Node temp=this.head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.print(null+"\n");
    }
    public void deleteSpecificPosition(int pos){
        if(pos<0 || pos >=this.length){
            System.out.println("Index is not valid.");
            return;
        }
        if(pos==0){
            deleteFront();
            return;
        }
        if(pos==this.length-1){
            System.out.println("working");
            deleteRear();
            return;
        }
        Node temp=traversal(pos-1);
        temp.next=temp.next.next;
    }
    public void deleteRear(){
        if(tail==null){
            System.out.println("List is empty");
            return;
        }
        if(this.length==1){
            deleteFront();
            return;
        }
        this.tail=this.traversal(this.length-2);
        this.tail.next=null;
        this.length--;
    }
    public int search(int val){
        Node temp=this.head;
        int count=0;
        while(temp!=null){
            if(temp.val==val)
                return count;
            temp=temp.next;
            count++;
        }
        return -1;
    }
    public int length(){
        return this.length;
    }
    public int get(int index){
        if(index<0 || index>=this.length){
            System.out.println("Index is not valid.");
            return -1;
        }
        Node temp=traversal(index);
        return temp.val;
    }
    public static void main(String[] args) {
        SLinkedList l=new SLinkedList();
        for(int i=0;i<10;i++){
            l.insertRear(i);
        }
        l.print();
        System.out.println(l.get(-8));
    }
    
}
