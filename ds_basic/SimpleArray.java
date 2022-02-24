public class SimpleArray {
    
    /**
     * In Java, all arrays are dynamically allocated and each has an index beginning from 0.
     * The direct superclass of an array type is Object.
     * Every array type implements the interfaces Cloneable and Serializable.
     * Storage:
     * In the case of primitive data types, the actual values are stored in contiguous memory locations.
     * In the case of class objects, the actual objects are stored in a heap segment.
     *
     * Allocation:
     * In Java, all arrays are dynamically allocated.
     * First, you must declare an array variable.
     * Second, you must allocate the memory using 'new'.
     * 'new' will initial to zero (for numeric types), false (for boolean), or null (for reference types).
    */

    public static void main(String[] args) {

        // Both declarations are valid. Only reference created.
        int intArrayAfter[];
        int[] intArrayBefore;

        // Allocate memory.
        intArrayAfter = new int[10];
        intArrayAfter[0] = 100;

        // clone() for 1D creates deep copy.
        intArrayBefore = intArrayAfter.clone(); 
        System.out.println(intArrayAfter == intArrayBefore);

        // Declaration and allocation combined into one.
        int intArrayCombine[] = new int[] {1, 2, 3, 4, 5};

        System.out.println(String.format("Class: %s", intArrayCombine.getClass()));

        for (int i = 0; i < intArrayCombine.length; i++) {
            System.out.println("Element " + i + " : " + intArrayCombine[i]);
        }

        // Multidimensional Arrays.
        int[][] intArray2D = new int[10][20]; // 2D Array.
        int[][][] intArray3D = new int[10][20][10]; // 3D Array.

        // Declaring and initializing 2D array
        int intArray2DInit[][] = {{2, 7, 9}, {3, 6, 1}, {7, 4, 2}};

        // clone() for 2D creates shallow copy.
        int cloneintArray2DInit[][] = intArray2DInit.clone();
        // Base references are different.
        System.out.println(intArray2DInit == cloneintArray2DInit);
        // Sub-array references are same.
        System.out.println(intArray2DInit[0] == cloneintArray2DInit[0]);
        System.out.println(intArray2DInit[1] == cloneintArray2DInit[1]);

    }

}
