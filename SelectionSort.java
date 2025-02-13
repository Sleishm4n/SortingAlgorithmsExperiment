/// SELECTION_SORT(A)
///     sorted = []
///     for i := 1 to n-1
///         min = i
///         for j := 1 to n-1
///             if A[j] < A[min]
///                 min = j
/// 
///         sorted.add(min)
///     return sorted             



public class SelectionSort {
    public static void selectionSort(int[] A){
        int n = A.length;
        for (int i = 0; i < n - 1; i++){
            int min = i;
            for (int j = i + 1; j < n; j++){
                if (A[j] < A[min]){
                    min = j;
                }
            }
            if (i != min){
                int temp = A[i];
                A[i] = A[min];
                A[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {12, 11, 13, 5, 6};
        selectionSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
