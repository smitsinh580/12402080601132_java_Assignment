import java.util.Arrays;

class ArrayOperations {
    int[] arr;

    // Constructor
    ArrayOperations(int[] arr) {
        this.arr = arr;
    }

    // Reverse Array
    void reverse() {
        System.out.print("Reversed Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Sort Array
    void sortArray() {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        System.out.print("Sorted Array: ");
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Search Element
    void search(int key) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element " + key + " found at index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element " + key + " not found");
        }
    }

    // Average
    void average() {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double avg = (double) sum / arr.length;
        System.out.println("Average: " + avg);
    }

    // Maximum
    void maximum() {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("Maximum: " + max);
    }
}

public class Program1 {
    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 7};

        // Create object
        ArrayOperations obj = new ArrayOperations(data);

        obj.reverse();
        obj.sortArray();
        obj.search(9);
        obj.average();
        obj.maximum();
    }
}
