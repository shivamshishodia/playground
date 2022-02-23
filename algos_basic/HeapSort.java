public class HeapSort {

    private void printArr(int[] unsortedArr) {
        for(int i = 0; i < unsortedArr.length; i++) {
            System.out.print(unsortedArr[i] + " ");
        }
        System.out.println(" ");
    }

    // Time complexity: O(logn)
    private void heapify(int[] arr, int size, int index) {

        // Assume that the root is largest.
        int largest = index;

        // Calculate the left and right children indexes.
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Check if left children is larger.
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right children is larger.
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // Swap the largest element.
        if (largest != index) {
            int swap = arr[largest];
            arr[largest] = arr[index];
            arr[index] = swap;
            heapify(arr, size, largest);
        }

    }

    // Time complexity: O(nlogn)
    private int[] sort(int[] arr) {

        int n = arr.length;

        // Build the heap.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        System.out.print("Heap : ");
        printArr(arr);

        // Replace first (largest element) with last and repeat.
        for (int i = n - 1; i > 0; i--) {
            int swap = arr[i];
            arr[i] = arr[0];
            arr[0] = swap;
            heapify(arr, i, 0);
        }

        return arr;
    }

    public static void main(String[] args) {
        
        int unsortedArr[] = {4, 5, 2, 1, 6, 3, 7};

        HeapSort obj = new HeapSort();
        System.out.print("Unsorted Array : ");
        obj.printArr(unsortedArr);
        
        obj.sort(unsortedArr);
        System.out.print("Heapsort : ");
        obj.printArr(unsortedArr);

    }

}
