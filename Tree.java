import java.io.*;
import java.util.*;
class Node
{
	Node left,right;
	int item;
	Node(int ite)
	{
     item=ite;
	}
}


class Tree
{
	Node root;
  
  void insert(int num)
  {
  	if(root==null)
  		root=new Node(num);
  	else
  	{
       Queue<Node> q=new LinkedList<Node>();
       q.add(root);
       while(q.size()>0)
       {
       	Node temp=q.remove();
       	if(temp!=null)
       	{
       		Node l=temp.left;
       		if(l==null)
       		{
       			temp.left=new Node(num);
       			break;
       		}
       		else
       			q.add(temp.left);
       		if(temp.right==null)
       		{
       			temp.right=new Node(num);
       			break;
       		}
       		else
       			q.add(temp.right);
        }
       }
  	}
  }


   void display()
   {
   	 Queue<Node> q=new LinkedList<Node>();
   	 q.add(root);
   	 while(q.size()>0)
   	 {
   	 	Node temp=q.remove();
   	 	System.out.print(temp.item+" ");
   	 	if(temp.left!=null)
   	 		q.add(temp.left);
   	 	if(temp.right!=null)
   	 		q.add(temp.right);
   	 }
      System.out.println("");
   }


void delete(int num)
{
     if(root.item==num)
     {
     	if(root.left==null && root.right==null)
     		root=null;
     	else if(root.left==null)
     		root=root.right;
     	else if(root.right==null)
     		root=root.left;
     	else
     	{
     		Node f=root;
     		while(f.left.left!=null)
     		{
     			f=f.left;
     		}
     		root.item=f.left.item;
     		f.left=null;
     	}
     	return;
     }
     else
     {

     	Queue<Node> q=new LinkedList<Node>();
     	q.add(root);
     	while(q.size()>0)
     	{
     		Node a=q.remove();
     		if(a.left.item==num)
     		{
     			if(a.left.left==null && a.left.right==null)
     				a.left=null;
     			else if(a.left.left==null)
     				a.left=a.left.right;
     			else if(a.left.right==null)
     		        a.left=a.left.left;
     		    else
     		    {
     		    	Node r=a.left;
     		    	while(a.left.left!=null)
     		    	{
     		    		a=a.left;
     		    	}
     		    	r.item=a.left.item;
     		    	a.left=null;
     		    }
     			return;
     		}
     		else if(a.right.item==num)
     		{
     			if(a.right.left==null && a.right.right==null)
     				a.right=null;
     			else if(a.right.left==null)
     				a.right=a.right.right;
     			else if(a.right.right==null)
     		        a.right=a.right.left;
     		    else
     		    {
     		    	Node r=a.right;
     		    	while(a.left.left!=null)
     		    	{
     		    		a=a.left;
     		    	}
     		    	r.item=a.left.item;
     		    	a.left=null;
     		    }
     			return;
     		}
            q.add(a.left);
            q.add(a.right);
     	}

     }
     System.out.println("Element not found");
}



void count()
{
       Queue<Node> q=new LinkedList<Node>();
     	q.add(root);	
     	int tt=0;
     	while(q.size()>0)
     	{
     		Node a=q.remove();
     		tt=tt+1;
     		if(a.left!=null)
     			q.add(a.left);
     		if(a.right!=null)
     			q.add(a.right);
     	}
     	System.out.println(tt);
}

   int height(Node r,int i)
   {
       if(r==null)
       	return 0;
       int l=height(r.left,i);
       int rr=height(r.right,i);
       return l>rr?1+l:rr+1;

   }

   void level(Node r)
   {
   	Queue<Node> q=new LinkedList<Node>();
   	if(r==null)
   		System.out.println("Tree is empty");
   	q.add(r);
   	ArrayList<ArrayList<Integer>> result=new 	ArrayList<ArrayList<Integer>> ();
   	while(q.size()>0)
   	{
   		int rr=q.size();
   		ArrayList<Integer> w=new ArrayList<Integer>();
   		for(int i=0;i<rr;i++)
   		{
   			Node sa=q.remove();
   			w.add(sa.item);
   			if(sa.left!=null)
   				q.add(sa.left);
   			if(sa.right!=null)
   				q.add(sa.right);
   		}
      result.add(w);
   	}
   	System.out.println(result);
   }
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Tree ob=new Tree();
		
		int b=1;
		while(b==1)
		{
          System.out.println("Enter 1 for insertion /n Enter 2 for deletion /n Enter 3 for display /n Enter 4 for no. of nodes in tree /n Enter 5 for height of tree /n Enter 6 for printing elements in level wise");
		   int t=Integer.parseInt(br.readLine()); 
		   if(t==1)
		   {
		   	System.out.println("Enter element ");
		   	int n=Integer.parseInt(br.readLine());
		   	ob.insert(n);
		   } 
		   else if(t==2)
		   {
		   	System.out.println("Enter the element to be deleted");
		   	int num=Integer.parseInt(br.readLine());
		   	ob.delete(num);
		   }
		   else if(t==3)
		   {
		   	ob.display();
		   }
             else if(t==4)
             {
             	ob.count();
             }
              else if(t==5)
              {
              	int ii=0;
              	int h=ob.height(ob.root,ii);
              	System.out.println(h);
              }
              else if(t==6)
              {
              	ob.level(ob.root);
              }
			System.out.println("Enter 1 for continue and 0 for exit");
			int y=Integer.parseInt(br.readLine());
			b=y;
		}
	}
}
