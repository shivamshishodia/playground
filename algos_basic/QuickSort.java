public class QuickSort {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int low, int high) {
        // Take the last element as pivot.
        int pivot = arr[high];
        // Most important tracker of pivot position (just -1 of the pivot).
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private int[] sorted(int[] arr, int low, int high) {
        if (low < high) {
            // Partition ensures that pivot has smaller elements
            // to the left and larger elements to the right.
            int pivot = partition(arr, low, high);

            // Divide and conquer.
            sorted(arr, low, pivot - 1);
            sorted(arr, pivot + 1, high);
        }
        return arr;
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        QuickSort obj = new QuickSort();

        int unsortedArr[] = {3, 5, 7, 1, 6, 2, 4};
        System.out.print("Unsorted Array : ");
        obj.printArr(unsortedArr);

        int sortedArr[] = obj.sorted(unsortedArr, 0, unsortedArr.length - 1);
        System.out.print("Sorted Array : ");
        obj.printArr(sortedArr);
        
    }
    
}
