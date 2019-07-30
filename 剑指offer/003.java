public class Solution {
    public boolean Find(int target, int [][] array) {
        Boolean found = false;
        if (array == null) {
            return found;
        }
        int row = 0;
        int col = array[0].length-1;
        while (col >= 0) {
            if (array[row][col] == target) {
                found = true;
                break;
            } else if (target > array[row][col]) {
                row = 1;
                while (row < array.length) {
                    if (array[row][col] > target) {
                        break;
                    } else if (array[row][col] == target) {
                        found = true;
                        break;
                    }
                    row++;
                }
            }
            col--;
            row = 0;
        }
        return found;
    }
}
