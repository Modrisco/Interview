import java.util.Arrays;

public class MergeSort {

    // @Override
    public int[] sort(int[] sourceArray) {
        // copy arr, does not change inside
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length/2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return mergeSort(sort(left), sort(right));
    }

    protected int[] mergeSort(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
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
        MergeSort ob = new MergeSort();
        ob.printArray(arr);
        int sortedArr[] = ob.sort(arr);
        System.out.println("sorted array: ");
        ob.printArray(sortedArr);
    }
}
