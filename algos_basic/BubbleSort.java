public class BubbleSort {

    private static int[] sorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // Last i elements are already in place 
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = swap;
                }
            }
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
        
        int arr[] = {6, 3, 5, 4, 7, 1, 2};
        System.out.print("Unsorted Array : ");
        printArr(arr);

        int sortedArr[] = sorted(arr);
        System.out.print("Sorted Array : ");
        printArr(sortedArr);

    }
    
}
