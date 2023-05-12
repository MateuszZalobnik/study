public class Test {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        
        System.out.println("Original Array: ");
        printArray(array);
        
        reverseArray(array2);
        
        System.out.println("Reversed Array: ");
        printArray(array2);
    }
    
    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        
        while (start < end) {
            // Swap elements
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            
            // Move indices towards the center
            start++;
            end--;
        }
    }
    
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
