public class SelectionSort {

    private static void printArr(int[] arr) {
        System.out.print("Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    private static int[] sorted(int[] unsortedArr) {
        // One by one move boundary of unsorted subarray.
        for (int i = 0; i < unsortedArr.length - 1; i++) {
            int minimum = i;
            // Find the minimum element in unsorted array.
            for (int j = i + 1; j < unsortedArr.length; j++) {
                if (unsortedArr[j] < unsortedArr[minimum]) {
                    minimum = j;
                }
            }
            // Swap the found minimum element with the first element.
            if (minimum != i) {
                int temp = unsortedArr[minimum];
                unsortedArr[minimum] = unsortedArr[i];
                unsortedArr[i] = temp;
            }
        }
        return unsortedArr;

    }

    public static void main(String[] args) {
        
        int unsortedArr[] = {5, 4, 6, 1, 2, 3, 7};
        printArr(unsortedArr);

        int sortedArr[] = sorted(unsortedArr);
        printArr(sortedArr);

    }
    
}
