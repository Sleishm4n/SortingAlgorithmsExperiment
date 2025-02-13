import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestAlgsOnDatasets {

    public static void runAlgs(String[] filenames){
        for (String filename : filenames) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Time taken to sort " + filename + ":");

            // Read array from file
            int[] arr = readArray(filename);
            if (arr == null) {
                System.out.println("Error reading file: " + filename);
                continue;
            }

           // Test Insertion Sort
           int[] arrCopy = arr.clone();
           System.out.print("InsertionSort: ");
           long startTime = System.currentTimeMillis();
           InsertionSort.insertionSort(arrCopy);
           long endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Selection Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("SelectionSort: ");
           startTime = System.currentTimeMillis();
           SelectionSort.selectionSort(arrCopy);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Shell Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("ShellSort: ");
           startTime = System.currentTimeMillis();
           ShellSort.shellSort(arrCopy);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Merge Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("MergeSort: ");
           startTime = System.currentTimeMillis();
           MergeSort.sort(arrCopy, 0, arrCopy.length - 1);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Merge-InsertionSort Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("MergeInsertionSort: ");
           startTime = System.currentTimeMillis();
           MergeSort.sortCutOff(arrCopy, 0, arrCopy.length - 1, 0);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Merge-BottomUp Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("MergeBottomUp: ");
           startTime = System.currentTimeMillis();
           MergeSort.bottomUpSort(arrCopy, 0, arrCopy.length - 1);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Quick Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("QuickSort: ");
           startTime = System.currentTimeMillis();
           Quicksort.quicksort(arrCopy, 0, arrCopy.length - 1);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Quick-Median3 Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("QuickSortMedian3: ");
           startTime = System.currentTimeMillis();
           Quicksort.sortMedian3(arrCopy, 0, arrCopy.length - 1);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Quick-Dutch Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("QuickDutch: ");
           startTime = System.currentTimeMillis();
           Quicksort.sort3Way(arrCopy, 0, arrCopy.length - 1);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");

           // Test Quick-InsertionSort Sort
           arrCopy = arr.clone(); // Reset array
           System.out.print("QuickInsertionSort: ");
           startTime = System.currentTimeMillis();
           Quicksort.sortCutOff(arrCopy, 0, arrCopy.length - 1, 0);
           endTime = System.currentTimeMillis();
           System.out.println((endTime - startTime) + " millieseconds");
        }
    }
    // Reads an array of integers from a file
    public static int[] readArray(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int size = 0;

            // Count the number of integers in the file
            while (scanner.hasNextInt()) {
                size++;
                scanner.nextInt();
            }
            scanner.close();

            // Read numbers into an array
            int[] arr = new int[size];
            scanner = new Scanner(new File(filename));
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
            scanner.close();

            return arr;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        }
    }

    // Method to check if an array is sorted
    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] filenames = {"AE1_files/dutch.txt"};
        runAlgs(filenames);
    }
}
