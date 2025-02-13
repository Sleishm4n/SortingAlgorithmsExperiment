
public class MergeSort {

    static void merge(int A[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + 1];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void sort(int A[], int p, int r){
        if (p < r){
            int q = (p + r)/2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void sortCutOff(int[] A, int p, int r, int n){
        if (r <= p + n -1){
            InsertionSort.insertionSort(A);
            return;
        }
        int q = p + (r - p) / 2;
        sort(A, p, q);
        sort(A, p, q);
        sort(A, q + 1, r);
        merge(A, p, q, r);
    }

    public static void bottomUpSort(int[] A, int p, int r){
        int n = r - p;
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (p = 0; p < n -sz; p += sz +sz){
                merge(A, p, p+sz-1, Math.min(p+sz+sz-1, n-1));
            }
        }

    }
}
