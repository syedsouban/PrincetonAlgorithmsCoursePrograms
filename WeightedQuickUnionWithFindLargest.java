/**
 * Created by Syed on 09-04-2018.
 */
public class WeightedQuickUnionWithFindLargest extends WeightedQuickUnion {
    int[] largest;
    public WeightedQuickUnionWithFindLargest(int n) {

        super(n);
        largest=id;

    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) return;
        int largestP = largest[rootp];
        int largestQ = largest[rootq];
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];

            if (largestP > largestQ)
                largest[rootq] = largestP;
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];

            if (largestQ > largestP)
                largest[rootp] = largestQ;
        }
    }

    public int find(int p) {
        return largest[root(p)];
    }

    public static void main(String a[]) {
        WeightedQuickUnionWithFindLargest canonicalQuickFind = new WeightedQuickUnionWithFindLargest(10);
        canonicalQuickFind.union(5, 2);
        canonicalQuickFind.union(2, 6);
        canonicalQuickFind.union(6, 9);

        System.out.print(canonicalQuickFind.find(6));
    }
}
