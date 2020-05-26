import java.io.*;
class Node
{
	int item;
	Node prev,next;
	Node(int it)
	{
		item=it;
	}
}

class DoublyLinkedList
{
     Node head,tail;
     int size=0;
     void insert(int value)
     {
     	if(head==null)
     	{
     		head=new Node(value);
        tail=head;
     	}
     	else
     	{
        tail.next=new Node(value);
        tail.next.prev=tail;
        tail=tail.next;
      }
     		
         size=size+1;
     }
  void display()
  {
  	if(head==null || size==0)
  	{
  		System.out.println("Empty Doubly LinkedList");
  	}
  	else
  	{
  		Node temp=head;
  		while(temp!=null)
  		{
  			System.out.print(temp.item+" ");
  			temp=temp.next;
  		}
  		System.out.println("");
  	}
  }


  void reverse()
  {
  	if(head==null)
  	{
  		System.out.println("Empty");
  	}
  	else
  	{
  		Node te=tail;
      while(te!=null)
      {
        System.out.print(te.item+" ");
        te=te.prev;
      }
  		System.out.println("");
  	}
  }


void delete(int it)
{
  int b=0;
     if(head==null)
     {
     System.out.println("Empty");
     return;
   }
     else if(head.item==it && head==tail)
     {
      head=null;
      tail=null;
      b=1;
      size=size-1;
        return;
     }
     else if(head.item==it)
     {
        head=head.next;
        head.prev=null;
        b=1;
        size=size-1;
        return;
     }
     else
     {
      Node te=head;
      while(te.next!=null)
      {
        if(te.next.item==it)
        {
          if(tail==te.next)
          {
            te.next=null;
            tail=te;
          }
          else
          {
            te.next=te.next.next;
            te.next.prev=te;
          }
          size=size-1;
          b=1;
          return;
        }
        te=te.next;
      }

     }
     if(b==0)
       System.out.println("Item not found");
     
     	
     
}




	public static void main(String args[])throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DoublyLinkedList obj=new DoublyLinkedList();
		int b=1;
		while(b==1)
		{
			System.out.println("Enter 1 for insertion /n Enter 2 for deletion /n Enter 3 for size of doubly linked list /n Enter 4 for display of doubly linked list /n Enter 5 for reverse traversal of doubly linked list");
			int t=Integer.parseInt(br.readLine());
			if(t==1)
			{
               System.out.println("Enter the value");
               int n=Integer.parseInt(br.readLine());
               obj.insert(n);
			}
			else if(t==2)
			{
              System.out.println("Enter the value for deletion");
               int n=Integer.parseInt(br.readLine());
               obj.delete(n);
			}
			else if(t==3)
			{
				System.out.println(obj.size);
			}
			else if(t==4)
			{
				obj.display();
			}
			else if(t==5)
			{
				obj.reverse();
			}
			System.out.println("Enter 0 for exit and 1 for continue");
			int y=Integer.parseInt(br.readLine());
			b=y;
		}
	}
}
