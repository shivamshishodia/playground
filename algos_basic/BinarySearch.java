public class BinarySearch {

    public static int search(int arr[], int left, int right, int element) {
        int middle = (left + right) / 2;
        if (left == right)
            return -1;
        if (element == arr[middle])
            return middle;
        if (element > arr[middle])
            return search(arr, middle + 1, right, element);
        return search(arr, left, middle - 1, element);
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int element = 6;

        int index = search(arr, 0, arr.length - 1, element);

        if (index == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at position " + (index + 1));
        }
        
    }
    
}
