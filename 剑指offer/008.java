import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (right + left) / 2;
            // {0,1,1,1,1} -> {1,0,1,1,1} || {1,1,1,0,1}
            if (array[left] == array[right] && array[left] == array[mid]) {
                return sortInOrder(array, left, right);
            } else if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }
    public int sortInOrder(int[] array, int left, int right) {
        int result = array[left];
        for (int i=left+1; i<right; i++) {
            if (result > array[i]) {
                array[i] = result;
            }
        }
        return result;
    }
}
