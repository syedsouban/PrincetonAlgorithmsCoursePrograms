/**
 * Created by Syed on 09-04-2018.
 */
public class CanonicalQuickFind extends QuickFind {
    public CanonicalQuickFind(int n) {
        super(n);
    }

    public int find(int p) {
        int c = id[p];
        int max = c;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == c) {
                if (max < i) {
                    max = i;
                }
            }
        }
        return max;
    }

    public static void main(String a[]) {
        CanonicalQuickFind canonicalQuickFind = new CanonicalQuickFind(10);
        canonicalQuickFind.union(1, 2);
        canonicalQuickFind.union(2, 6);
        canonicalQuickFind.union(6, 9);
        canonicalQuickFind.union(0, 7);
        System.out.print(canonicalQuickFind.find(7));
    }
}
