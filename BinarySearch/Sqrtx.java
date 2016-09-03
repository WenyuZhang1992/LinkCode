/**
     * Description:
     * Implement int sqrt(int x).
     * Compute and return the square root of x.
     * 
     * Analysis: we can still use binary search. The difference is there is no 
     *           array or target. But we can regard the int list 0 to x/2+1 as a new array
     *
     * Notice: 1. Special cases: x = 0, x = 1, return x directly;
     *         2. After loops, when compare start and end, consider the situation when end^2>x
     */
class Sqrtx {
    public int sqrt(int x) {
        // write your code here
        if (x < 0){
            return -1;
        }
        if (x == 0 || x == 1){
            return x;
        }
        
        int start, end, middle;
        start = 0;
        end = x/2 + 1;
        
        while(start+1 < end){
            middle = start + (end-start)/2;
            if (Math.pow(middle, 2) == x){
                return middle;
            }
            else if (Math.pow(middle, 2)<x){
                start = middle;
            }
            else{
                end = middle;
            }
        }
        
        if (x-Math.pow(end, 2)>0 && x-Math.pow(start, 2)>x-Math.pow(end, 2)){
            return end;
        }
        else{
            return start;
        }
        
    }
}