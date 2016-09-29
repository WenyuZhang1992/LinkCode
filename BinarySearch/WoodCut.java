class WoodCut {
    /** Description:
      * Given n pieces of wood with length L[i] (integer array). 
      * Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
      * What is the longest length you can get from the n pieces of wood? 
      * Given L & k, return the maximum length of the small pieces.
      *
      * Analysis: we do not use binary search on attay any more but rather use it in length.
      *           The length ranges from 0 to max of the array(we only have 1 piece on maxPiece)
      *           Steps: 1. Calculate the maximum of the array
      *                  2. Choose middle, calculate the count of pieces we could have in this length
      *                  3. If the count >= k, we can move to longer length; otherwise, move to shorter length
      *                  4. Find the longest length that can satisfy k
      *
      * Notice: 1. Even though we find count of middle == k, we can not return middle directly cause we have multiple length with same count;
      *         2. We should consider the situation when no length could satisfy the k(k is too large), this situation will have start = 0 !!!
     */
    public static int woodCut(int[] L, int k) {
        // write your code here

        if (L.length == 0 || L == null){
            return 0;
        }

        int maxPiece = L[0];
        for (int i:L){
            if (i>maxPiece){
                maxPiece = i;
            }
        }

        int start = 0;
        int end = maxPiece;
        int middle;
        int count = 0;

        while(start+1<end){
            middle = start + (end-start)/2;
            for(int j:L){
                count += j/middle;
            }
            if (count<k){
                end = middle;
            }
            // When count == k, make start = middle instead of return middle directly!!!
            else{
                start = middle;
            }
            count = 0;
        }

        int endCount = 0;
        for (int j:L){
            endCount += j/end;
        }
        // Special case: when k is too large
        if (start == 0 && endCount < k){
            return start;
        }
        else if (endCount>=k){
            return end;
        }
        else{
            return start;
        }

        
    }
}
