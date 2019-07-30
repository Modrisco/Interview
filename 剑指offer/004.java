public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int numSpace = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                numSpace++;
            }
        }
        int indexOld = str.length() - 1;
        int strLength = str.length() + numSpace * 2;
        str.setLength(strLength);
        int indexNew = str.length() - 1;
        while (indexNew > indexOld) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew, '0');
                str.setCharAt(indexNew-1, '2');
                str.setCharAt(indexNew-2, '%');
                indexNew-=3;
            } else {
                str.setCharAt(indexNew, str.charAt(indexOld));
                indexNew--;
            }
            indexOld--;
        }
        return str.toString();
    }
}
