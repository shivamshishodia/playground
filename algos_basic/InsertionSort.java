public class InsertionSort {

    private static int[] sorted(int[] arr) {

        int n = arr.length;
        // We start from 1 index not 0.
        for (int i = 1; i < n; i++) {
            // Select the key to be inserted in the left subarray.
            int key  = arr[i];
            int j = i - 1;
            // Keep on swapping till greatest elements are found in the left subarray.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert the key after greatest elements are swapped to right.
            arr[j + 1] = key;
            System.out.print("Array Pass " + (i + 1) + " : ");
            printArr(arr);
        }
        return arr;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        
        int unsortedArr[] = {3, 5, 7, 1, 6, 2, 4};
        System.out.print("Unsorted Array : ");
        printArr(unsortedArr);

        int sortedArr[] = sorted(unsortedArr);
        System.out.print("Sorted Array : ");
        printArr(sortedArr);

    }
    
}
