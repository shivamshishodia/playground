import java.util.Collections;
import java.util.Vector;

public class BucketSort {

    private float[] sorted(float[] arr) {
        int n = arr.length;

        // Create buckets.
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        // Create list for each bucket.
        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Float>();
        }

        // Place elements in the buckets.
        for (int i = 0; i < n; i++) {
            float idx = n * arr[i];
            buckets[(int) idx].add(arr[i]);
        }

        // Sort each bucket collection.
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Merge all the elements into one.
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
        return arr;

    }

    private void printArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        BucketSort obj = new BucketSort();

        float unsortedArr[] = { 
            (float) 0.897, (float) 0.565,
            (float) 0.656, (float) 0.1234,
            (float) 0.665, (float) 0.3434 
        };
        
        System.out.print("Unsorted Array : ");
        obj.printArr(unsortedArr);

        float sortedArr[] = obj.sorted(unsortedArr);
        System.out.print("Sorted Array : ");
        obj.printArr(sortedArr);

    }

}
