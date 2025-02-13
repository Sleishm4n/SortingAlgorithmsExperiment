public class ShellSort {
    
    public static void shellSort(int[] A){
        int h = 1;
        int n = A.length;
        while (h < n/3){
            h = 3*h + 1;
        }
        while (h >= 1){
            for (int i = h; i < n; i ++){
                for (int j = i; j >= h && A[j] < A[j-h]; j -= h){
                    swap(A, j, j-h);
                }
            }
            h = h / 3;
        }
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // public static void main(String[] args) {
    //     int[] array = {64, 34, 25, 12, 22, 11, 90, 11};
    //     ShellSort main  = new ShellSort();
    //     main.shellSort(array);
    //     System.out.println("Sorted array: ");
    //     for (int i : array) {
    //         System.out.print(i + " ");
    //     }
}
