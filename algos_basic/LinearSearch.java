public class LinearSearch {

    public static int search(int arr[], int element) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        int arr[] = {1, 5, 3, 2, 6, 7, 9, 8};
        int element = 6;
        int index = search(arr, element);

        if (index == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at : " + (index + 1));
        }

    }

}