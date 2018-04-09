import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Syed on 27-02-2018.
 */
public class WeightedQuickUnion {
    protected int[] id,sz;
    WeightedQuickUnion(int n)
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
            id[p]=id[id[p]]; //path compression
            p=id[p];
        }
        return p;
    }
    boolean connected(int p,int q)
    {
        return root(p)==root(q);
    }
    public void union(int p,int q)
    {
        if(p==q) return;
        if(sz[p]<sz[q])
        {
            id[root(p)]=root(q);
            sz[q]+=sz[p];
        }
        else
        {
            id[root(q)]=root(p);
            sz[p]+=sz[q];
        }
    }
    public void display()
    {
        for(int i=0;i<id.length;i++)
        {
            System.out.print(id[i]+" ");
        }
    }
    public static void main(String a[]) throws IOException, InterruptedException
    {
        WeightedQuickUnion wqu=new WeightedQuickUnion(8);
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("1. Union\n2. Connected\n3. Display\n4. Exit");
        System.out.println("Enter your choice: ");
        choice=scanner.nextInt();
        while(choice!=4)
        {
            if(choice==1)
            {
                int x1,x2;
                System.out.println("Enter two numbers: ");
                x1=scanner.nextInt();
                x2=scanner.nextInt();
                wqu.union(x1,x2);
            }
            if(choice==2)
            {
                int x1,x2;
                System.out.println("Enter two numbers: ");
                x1=scanner.nextInt();
                x2=scanner.nextInt();
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
            choice=scanner.nextInt();
        }
    }
}
