import java.util.Arrays;

public class QuickSort {

    // @Override
    public int[] sort(int[] sourceArray) {
        // copy arr, does not change inside
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length-1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // set pivot
        int pivot = left;
        int index = pivot + 1;
        for(int i=index; i<=right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index-1;
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
        QuickSort ob = new QuickSort();
        ob.printArray(arr);
        int sortedArr[] = ob.sort(arr);
        System.out.println("sorted array: ");
        ob.printArray(sortedArr);
    }
}