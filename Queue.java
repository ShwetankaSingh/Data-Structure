import java.io.*;
class Node
{
	Node next;
	int item;
	Node(int it)
	{
		item=it;
	}
}

class Queue
{
     Node front,rear; //insert from rear and delete from front
     int size=0;
     void insert(int it)
     {
       if(front==null || rear ==null)
       {
       	Node n=new Node(it);
       	front =n;
       	rear=n;
       }
       else
       {
       	Node n=new Node(it);
       	n.next=rear;
       	rear=n;
       }
       size=size+1;
     }

     void delete()
     {
     	if(front==null || rear==null)
     	{
     		System.out.println("Emoty queue");
     	}
     	else
     	{
     		if(rear==front)
     		{
     			rear=null;
     			front=null;
     		}
     		else
     		{
     			Node tem=rear;
     			while(tem.next!=front)
     			{
     				tem=tem.next;
     			}
     			tem.next=null;
     			front =tem;
     		}
     		size=size-1;
     	}
     }

   void display()
   {
   	if(size==0)
   		System.out.println("Empty queue");
   	else
   	{
   		Node te=rear;
   		while(te!=front)
   		{
   			System.out.print(te.item+" ");
   			te=te.next;
   		}
   		System.out.print(front.item+" ");
   		System.out.println("");
   	}
   }




	public static void main(String args[])throws IOException 
	{
		Queue obj=new Queue();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int b=1;
        while(b==1)
        {
           System.out.println("Enter 1 for insert /n Enter 2 for delete /n Enter 3 for size of stack /n Enter 4 for stack display");
           int t=Integer.parseInt(br.readLine());
           if(t==1)
             {
              int n=Integer.parseInt(br.readLine());
              obj.insert(n);
             }
             else if(t==2)
              {
         	obj.delete();
              }
          else if(t==3)
             {
          	System.out.println(obj.size);
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
