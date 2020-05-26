import java.io.*;
class Node
{
	Node next;
	int item;
	Node(int value)
	{
		item=value;
	}
}

class CircularLinkedList
{
    Node head;
    int size=0;
    void insert(int it)
    {
    	if(head==null)
    	{
    		head=new Node(it);
    		head.next=head;
    	}
    	else
    	{
    		Node temp=head;
    		while(temp.next!=head)
    		{
    			temp=temp.next;
    		}
    		temp.next=new Node(it);
    		temp.next.next=head;
    	}
    	size=size+1;
    }
  

  void display()
  {
  	if(head==null)
  	{
  		System.out.println("Empty");
  		return;
  	}

  	Node temp=head;
  	do
  	{
  		System.out.print(temp.item+" ");
  		temp=temp.next;
  	}while(temp!=head);
  	System.out.println("");
  }

void delete(int it)
{
	int u=0;
    if(head==null)
    {
    	System.out.println("Empty");
    	return;
    }
    else if(head.item==it && size==1)
    {
    	head=null;
    	size=0;
    	return;
    }
    else
    {
    	Node temp=head;
    	do
    	{
            if(temp.next.item==it)
            {
            	if(temp.next==head)
            	{
                   temp.next=temp.next.next;
                   head=temp.next;
            	}
            	else
            	{
            		temp.next=temp.next.next;
            	}
            	size=size-1;
            	u=1;
            	return;
            }
            temp=temp.next;
    	}while(temp!=head);
    }
    if(u==0)
    	System.out.println("Not found bro....xD");
}

	public static void main(String args[])throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		CircularLinkedList obj=new CircularLinkedList();
		int b=1;
		while(b==1)
		{
		System.out.println("Enter 1 for insertion /n Enter 2 for delettion /n Enter 3 for display /n Enter 4 for getting size of list");
		int t=Integer.parseInt(br.readLine());
		if(t==1)
		{
			System.out.println("Enter value to be insert");
			int n=Integer.parseInt(br.readLine());
			obj.insert(n);
		}
		else if(t==2)
		{
			System.out.println("Enter value to be deleted");
			int n=Integer.parseInt(br.readLine());
			obj.delete(n);
		}
		else if(t==3)
		{
			obj.display();
		}
		else if(t==4)
		{
			System.out.println(obj.size);
		}
		System.out.println("Enter 0 for exit and 1 for continue");
		int y=Integer.parseInt(br.readLine());
		b=y;
	    }
	}
}
