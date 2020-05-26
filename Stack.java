import java.io.*;
class Node
{
	int item;
	Node next;
	Node(int val)
	{
		item=val;
	}
}

class Stack
{
	Node top;
	int size=0;
	void push(int it)
	{
		if(top==null)
		{
			top=new Node(it);
		}
		else
		{
			Node b=new Node(it);
			b.next=top;
			top=b;
		}
		size=size+1;
	}


	void pop()
	{
		if(size==0)
			System.out.println("Underflow");
		else
		{
			Node temp=top;
			top=temp.next;
			size=size-1;
		}
	}


	void display()
	{
		if(size==0)
			System.out.println("Empty");
		else
		{
			Node tem=top;
			while(tem!=null)
			{
			System.out.print(tem.item+" ");
			tem=tem.next;	
			}
		}
	}
	public static void main(String args[])throws IOException
	{
		Stack obj=new Stack();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int b=1;
        while(b==1)
        {
         System.out.println("Enter 1 for push /n Enter 2 for pop /n Enter 3 for size of stack /n Enter 4 for stack display");
         int t=Integer.parseInt(br.readLine());
         if(t==1)
         {
           int n=Integer.parseInt(br.readLine());
           obj.push(n);
         }
         else if(t==2)
         {
         	obj.pop();
         }
          else if(t==3)
          {
          	System.out.println(obj.size);
          }
          else if(t==4)
          {
          	obj.display();
          }
          System.out.println("Enter 1 for continue and 0 for exit");
          int g=Integer.parseInt(br.readLine());
          b=g;

        }
	}
}
