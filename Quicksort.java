import java.util.Random;

public class Quicksort {
    
    public static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r-1; j++){
            if  (A[j] <= x){
                i = i + 1;
                swap(A, i, j);
            }
        }
        swap(A, i+1, r);
        return i + 1;
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void quicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A, q+1, r);
        }
    }

    public void rQuickSort(int[] A, int p, int r){
        if (p < r){
            Random random = new Random();
            swap(A, random.nextInt(r-p) + p, r);
            int q = partition(A, p, r);
            rQuickSort(A, p, q-1);
            rQuickSort(A, q+1, r);
        }
    }

    private static void kSort(int A[], int p, int r, int k){
        if (r - p <= k) return;
        int q = partition(A, p, r);
        kSort(A, p, q-1, k);
        kSort(A, q+1, r, k);
    }

    public static void sortCutOff(int A[], int p, int r, int k){
        kSort(A, p, r, k);
        InsertionSort.insertionSort(A);
    }

    public static void sort3Way(int[] A, int l, int r){
        if (r <= l) return;

        int v = A[r];
        int i = l-1, j = r, p = l-1, q =r, k;

        for (;;) {
            while (A[++i] < v);
            while (v < A[--j]) if (j == l) break;
            if  ( i >= j) break;
            swap(A, i, j);
            if (A[i] == v) { p++; swap(A, p, i); }
            if (A[j] == v) { q--; swap(A, q, j); }
        }

        swap(A, i, r);
        j = i -1;
        i = i + 1;
        for (k = l; k <= p; k++, j--){
            swap(A, k ,j);
        }
        for (k = r-1; k >= q; k--,i++){
            swap(A, k, i);
        }
        sort3Way(A, l, j);
        sort3Way(A, i, r);
    }

    public static void sortMedian3(int A[], int p, int r){
        if (r <= p) return;
        swap(A, (p+r)/2, r-1);
        if (A[r-1] < A[p]) swap(A, p, r-1);
        if (A[r] < A[p]) swap(A, p, r);
        if (A[r] < A[r-1]) swap(A, r-1, r);
        int  q = partition(A, p+1, r-1);
        sortMedian3(A, p, q-1);
        sortMedian3(A, q+1, r);
    }
}
