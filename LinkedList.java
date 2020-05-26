import java.io.*;
class Node
{
  int item;
  Node next;
  Node(int it)
  {
  	item=it;
  }
}

class LinkedList
{
	Node root;
	int size=0;
	void insert(int value)
	{
       if(root==null)
       	root=new Node(value);
       else
       {
       	Node temp=root;
       	while(temp.next!=null)
       	{
       		temp=temp.next;
       	}
       	temp.next=new Node(value);
       }
        size=size+1;
	}
     

     void delete(int value)
     {
     	if(root==null)
     		System.out.println("Linked List is empty");
     	if(root.item==value)
     	{
     		root=root.next;
     		size=size-1;
     	}
     	else
     	{
     		int p=1;
     		Node temp=root;
     		while(temp.next!=null)
     		{
     			if(temp.next.item==value)
     			{
     				temp.next=temp.next.next;
     				p=0;
     				return;
     			}
     			temp=temp.next;
     		}
     		if(p==1)
                System.out.println("Item is not found");
     	}
     }
    

    void display()
    {
    	if(size==0)
    	{
    	System.out.println("Empty");	
    	}
    	else
    	{
    		Node temp=root;
    		while(temp!=null)
    		{
    			System.out.print(temp.item+" ");
    			temp=temp.next;
    		}
    		System.out.println("");
    	}
    }

	public static void main(String args[])throws IOException
	{
		LinkedList obj=new LinkedList();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int b=1;
         while(b==1)
         {
         	System.out.println("Enter 1 for insert/n Enter 2 for length /n Enter 3 for deletion /n Enter 4 for display");
             int t=Integer.parseInt(br.readLine());
             if(t==1)
             {
             	System.out.println("Enter the item value");
             	int n=Integer.parseInt(br.readLine());
             	obj.insert(n);
             }
             else if(t==2)
             {
             System.out.println(obj.size);	
             }
              else if(t==3)
              {
              	System.out.println("Enter the item value which you want to delete");
              	int n=Integer.parseInt(br.readLine());
              	obj.delete(n);
              }
              else if(t==4)
              {
              	obj.display();
              }
              System.out.println("Enter 0 for quit or 1 for continue");
              int y=Integer.parseInt(br.readLine());
              b=y;

         }
	}
}
