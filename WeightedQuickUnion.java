import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Syed on 27-02-2018.
 */
public class WeightedQuickUnion {
    int[] id,sz;
    public WeightedQuickUnion(int n)
    {
        id=new int[n];
        sz=new int[n];
        for(int i=0;i<n;i++)
        {
            id[i]=i;
            sz[i]=1;
        }
    }
    private int root(int p)
    {
        while(p!=id[p])
        {
            p=id[p];
        }
        return p;
    }
    public boolean connected(int p,int q)
    {
        return root(p)==root(q);
    }
    public void union(int p,int q)
    {
        if(sz[p]<sz[q])
        {
            id[root(p)]=root(q);
            sz[q]+=sz[p];
        }
        else if(sz[p]>sz[q])
        {
            id[root(q)]=root(p);
            sz[p]+=sz[q];
        }
        else
        {
            id[root(p)]=root(q);
            sz[q]+=sz[p];
        }

    }
    public void display()
    {
        for(int i=0;i<id.length;i++)
        {
            System.out.print(id[i]+" ");
        }
    }
    public static void main(String a[]) throws IOException
    {
        WeightedQuickUnion wqu=new WeightedQuickUnion(8);
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        int choice;
        System.out.println("1. Union\n2. Connected\n3. Display\n4. Exit");
        System.out.println("Enter your choice: ");
        choice=Integer.parseInt(b.readLine());
        while(choice!=4)
        {
            if(choice==1)
            {
                int x1,x2;
                System.out.println("Enter two numbers: ");
                x1=Integer.parseInt(b.readLine());
                x2=Integer.parseInt(b.readLine());
                wqu.union(x1,x2);
            }
            if(choice==2)
            {
                int x1,x2;
                System.out.println("Enter two numbers: ");
                x1=Integer.parseInt(b.readLine());
                x2=Integer.parseInt(b.readLine());
                if(wqu.connected(x1,x2))
                {
                    System.out.println("Connected");
                }
                else
                {
                    System.out.println("Not Connected");
                }
            }
            if(choice==3)
            {
                wqu.display();
            }
            System.out.println("Enter your choice: ");
            choice=Integer.parseInt(b.readLine());
        }
    }
}
