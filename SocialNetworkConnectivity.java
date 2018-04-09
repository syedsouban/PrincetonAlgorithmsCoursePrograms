import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Syed on 09-04-2018.
 */
public class SocialNetworkConnectivity extends WeightedQuickUnion
{
    private int numberOfConnectedComponents=id.length;

    public SocialNetworkConnectivity(int n)
    {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        if(!(connected(p,q)))
        {
            --numberOfConnectedComponents;
        }
        super.union(p, q);
    }

    public int getNumberOfConnectedComponents() {
        return numberOfConnectedComponents;
    }

    public void setNumberOfConnectedComponents(int numberOfConnectedComponents) {
        this.numberOfConnectedComponents = numberOfConnectedComponents;
    }

    public void display()
    {
        for(int iid:id)
        {
            System.out.print(iid+" ");
        }
        System.out.print("\n");
    }

    public static void main (String a[])throws InterruptedException, IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of users in the social network: ");
        int N = scanner.nextInt();

        SocialNetworkConnectivity socialNetwork = new SocialNetworkConnectivity(N);

        System.out.println("Enter number of union operations to be performed: ");
        int M=scanner.nextInt();
        int p,q;
        long timestamp;

        for(int i=0;i<M;i++)
        {
            System.out.println("Enter elements to be connected: ");
            p=scanner.nextInt();
            q=scanner.nextInt();
            timestamp=new Date().getTime();
            socialNetwork.union(p,q);
            socialNetwork.display();

            if(socialNetwork.getNumberOfConnectedComponents()==1)
            {
                System.out.println("All the users in the social network at connected at" +
                        ": "+timestamp);
            }
        }
    }
}
