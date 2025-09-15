import org.w3c.dom.Node;

import java.util.Scanner;
class LinkedList_op{
    Node head;
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    LinkedList_op(){
        head=null;
    }
    public void add_begain(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            head=newNode;
            head.next=temp;
        }
    }
    public void add_end(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public void add_middle(int pos,int data){
        Node newNode=new Node(data);
        if(pos==0){
            add_begain(data);
        }
        else{
            Node temp=head;
            for(int i=1;i<pos;i++){
                temp=temp.next;
            }
            Node temp1=temp.next;
            temp.next=newNode;
            newNode.next=temp1;

        }
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public void length(){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println(count);
    }



    public void delete_begain(){
        Node temp=head;
        head=temp.next;
        temp=null;
    }
    public void delete_end(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    public void delete_middle(int pos){
        Node temp=head;
        if(pos==0){
            delete_begain();
        }
        else{
            for(int i=1;i<pos;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }
}
public class LinkedList
{
    public static void main(String args[])
    {
        LinkedList_op ll=new LinkedList_op();
        System.out.println("Welcome to the Singly Linked List:\nPlease choose the operation");
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.ADD_ELEMENT\n2.DELETE_ELEMENT\n3.LENGTH\n4.DISPLAY\n5.EXIT");
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.println("1.ADD_AT_BEGAIN\n2.ADD_AT_END\n3.ADD_AT_MIDDLE");
                int choice1=sc.nextInt();
                if(choice1==1)
                {
                    System.out.println("Enter the data to be added to the Singly Linked List");
                    int data=sc.nextInt();
                    ll.add_begain(data);
                }
                else if(choice1==2)
                {
                    System.out.println("Enter the data to be added from the Singly Linked List");
                    int data=sc.nextInt();
                    ll.add_end(data);
                }
                else if(choice1==3)
                {
                    System.out.println("Enter the value and the position of the element to be added to the Singly Linked List\nposition");
                    int pos=sc.nextInt();
                    System.out.println("Data");
                    int data=sc.nextInt();
                    ll.add_middle(pos,data);
                }
            }
            else if(choice==2){
                System.out.println("1.DELETE_AT_BEGAIN\n2.DELETE_AT_END\n3.DELETE_AT_POSITION");
                int choice1=sc.nextInt();
                if(choice1==1){
                    ll.delete_begain();
                }
                if(choice1==2){
                    ll.delete_end();
                }
                else if(choice1==3){
                    System.out.println("Enter the position of the element to be deleted from the Singly Linked List");
                    int pos=sc.nextInt();
                    ll.delete_middle(pos);
                }
            }
            else if(choice==3){
                System.out.println("The length is: ");
                ll.length();
                System.out.println();
            }
            else if(choice==4){
                System.out.println("Enter the value to be displayed in the Singly Linked List");
                ll.display();
                System.out.println();
            }
            else if(choice==5){
                System.out.println("Thank you for using Singly Linked List");
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }

    }
}
