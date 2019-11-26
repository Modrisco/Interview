import java.util.Arrays;

public class Heapsort {

    public int[] sort(int [] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        // build max heap
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        System.out.println(Arrays.toString(arr));
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void printArray(int arr[]) {
        int n = arr.length;
        String arrStr = "";
        for (int i=0; i<n; i++) {
            arrStr += Integer.toString(arr[i]) + " ";
        }
        System.out.println(arrStr);
    }

    public static void main(String args[]) {
        int arr[] = {10,7,8,1,9,5};
        System.out.println("Before sorted: ");
        Heapsort ob = new Heapsort();
        ob.printArray(arr);
        int sortedArr[] = ob.sort(arr);
        System.out.println("sorted array: ");
        ob.printArray(sortedArr);
    }

}
