import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Syed on 26-02-2018.
 */
public class QuickFind {
    int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (pid == id[i]) {
                id[i] = qid;
            }
        }
    }
    public void display() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
    }


    public static void main(String a[]) throws IOException {
        QuickFind qf = new QuickFind(8);
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        System.out.println("1. Union\n2. Connected\n3. Display\n4. Exit");
        System.out.println("Enter your choice: ");
        choice = Integer.parseInt(b.readLine());
        while (choice != 4) {
            if (choice == 1) {
                int x1, x2;
                System.out.println("Enter two numbers: ");
                x1 = Integer.parseInt(b.readLine());
                x2 = Integer.parseInt(b.readLine());
                qf.union(x1, x2);
            }
            if (choice == 2) {
                int x1, x2;
                System.out.println("Enter two numbers: ");
                x1 = Integer.parseInt(b.readLine());
                x2 = Integer.parseInt(b.readLine());
                if (qf.connected(x1, x2)) {
                    System.out.println("Connected");
                } else {
                    System.out.println("Not Connected");
                }
            }
            if (choice == 3) {
                qf.display();
            }
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(b.readLine());
        }
    }
}
