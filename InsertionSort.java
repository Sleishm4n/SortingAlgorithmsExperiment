public class InsertionSort {
    public static void insertionSort(int[] A) {
        int n = A.length;
        for (int j = 1; j < n; j++) {
            int key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] A = {12, 11, 13, 5, 6};
        insertionSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}

