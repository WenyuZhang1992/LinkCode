public class RotateString {
    /** Description:
      * Given a string and an offset, rotate string by offset. (rotate from left to right)
      *
      * Analysis: Similar to problem Recover Rotated Sorted Array.
      *           Reverse the 3-Step method
      *
      * Notice: Special cases: 1. When str is null or str.length = 0, return the original str directly;
      *                        2. When offset > str.length, we assign offset = offset % str.length           
     */
    public static void reverse(char[] str, int start, int end){
        char temp;
    	for (int i=start, j=end; i<j; i++, j--){
    		temp = str[i];
    		str[i] = str[j];
    		str[j] = temp;
    	}
    } 

    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length == 0 || str == null){
            return;
        }
        char temp;
        if (offset > str.length){
            offset = offset % str.length;
        }

        if (offset > 0){
        	reverse(str, 0, str.length-1);
        	reverse(str, 0, offset-1);
        	reverse(str, offset, str.length-1);
        }
    }
}