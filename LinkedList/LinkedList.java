public class LinkedList {

    public static class Node {
        int data;
        Node next;

        // Constructor for Node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private static int size =0;
    
        public void addStart(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                size++;
                return;
            }
            newNode.next = head;
            head = newNode;
            size++;
        }
    
        public void addEnd(int data) {
            Node newNode = new Node(data);
            if (tail == null) {
                head = tail = newNode;
                size++;
                return;
            }
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    
        public void print() {
            if (head == null) {
                System.out.println("LINKED LIST IS EMPTY");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

    //REMOVE IN A LINKED LIST
 public int  removeFirst() {
    int val=head.data;
    if(size==0){
        System.out.println("LINKED LIST IS EMPTY");
        return  -1;
    
    }
    if(size==1){
        int value=head.data;
        head=tail=null;
        size=0;
        return value;
    }
    head=head.next;
    return val;
   } 
  //=----------------------------------- REMOVE FROME END ---------------------------------------------------------- 
  public void removeTail() {
    if (size == 0) { 
        System.out.println("LINKED LIST IS EMPTY");
        return;
    }

    if (size == 1) { 
        head = tail = null; 
        size = 0;
        return;
    }

    // General case: More than one node
    Node temp = head;
    for (int i = 0; i < size - 2; i++) { 
        temp = temp.next;
    }
    
    
    temp.next = null;
    tail = temp;
    size--;
}


 //------------------------ ADD IN THE MID OF THE LINKED LIST-------------------------
        public  void add(int idx,int data){
            Node newNode=new Node(data);
            size++;
           Node temp=head;
           int i=0;
           while(i<idx-1){
               temp= temp.next;
               i++;
            }
            newNode.next=temp.next;
            temp.next=newNode;
       
        }
// =---------------------------------------------search in linked list-----------------------------------------------------------------
public int search(int key){
    Node temp=head;
     int i=0;
    while(temp!=null){
       
        if(temp.data==key){
            return i;
        }

        temp=temp.next;
        i++;

    }
    return-1;


}

// Search using recursive function in Linked List--------------------------------------------------------------------------------

public int searchRec(int key){
    return helper( head,key);
}
 public int helper(Node head,int key){
    if(head==null){
        return -1;
    }
    
    if( head.data==key){
        return 0;
    }
    int idx=helper(head.next, key);
    if(idx==-1){
        return -1;
    }
    return idx+1; 
}
//---------------------------------Reverse of Linked List----------------------------------------------------
public void reverse() {
    if (head == null || head.next == null) { // Edge cases: empty list or single node
        return;
    }

    Node prev = null;
    Node curr = head;
    tail = head; 

    while (curr != null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    head = prev; // Update head to the new head (previously the tail)
}
// ------ REMOVE NTH NODE FROM  END----------------
public void deleteFromEnd(int n){
    int size=0;
    Node temp=head;
    while(temp!=null){
        temp=temp.next;
        size++;

    }
    // for deleteing head or 1st singly linked list
    if(n==size){
        head.next=null;
        return;
    }
    int i=0;
    Node prev =head;
    int iTofind=size-n;
    while(i<iTofind){
        prev=prev.next;
        i++;

    }
    prev.next=prev.next.next;
    return;
}
// =----------------------------------CHECK IS THIS LINKED LIST IS PALINDOME-----------------------------------------
public Node findmid(Node head){
    Node slow=head;
    Node fast=head;
    while (fast != null && fast.next != null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return  slow;
}
 public boolean checlPalindrome(){
    if(head==null||head.next==null){
        return true;
    }
    Node midNode=findmid(head);
    Node prev=null;
    Node curr=midNode;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
     Node right=head;
     Node left=head;
     if(left.data!=right.data){
        return false;

     }
     return true;
 }
         
     

        public static void main(String[] args) {
            LinkedList list = new LinkedList(); 
    
            list.addStart(1);
            list.addStart(2);
            list.addEnd(14);
            
            list.print();
        
            list.add(2,3);
            list.print(); 
            System.out.println("Size of LinkedList == s"+size);
            System.out.println();
            System.out.println("Key found on index = "+list.search(14));
            System.out.println();
            System.out.println("Key found on index Using  recursive function= "+list.searchRec(3));
            System.out.println();

            System.out.println("Reverse Linked List");
            list.reverse();
            list.print();
            list.deleteFromEnd(2);
            list.print();
            System.out.println();
            System.out.println(" Linked List  2");
            System.out.println();
            LinkedList list2 = new LinkedList(); 
            list2.addStart(2);
            list2.addStart(1);
          
            list2.addEnd(1);
            list2.print();
         
         
            System.out.println(list2.checlPalindrome()); 
            
            
    }
}
