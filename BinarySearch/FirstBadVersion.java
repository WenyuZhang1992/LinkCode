class FirstBadVersion {
    /** Description:
      * The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, 
      * so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.
	  * You can call isBadVersion to help you determine which version is the first bad one. 
	  * The details interface can be found in the code's annotation part.
	  *
	  * Analysis: Similar to the problem finding target in a sorted array
	  *           Difference is before the target are all false, after and includng the target are all true
	  *
	  * Notice: Special cases: 1. when n = 1 and it's the first bad version;
	  *                        2. All are bad versions;
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 1 && SVNRepo.isBadVersion(1) == true){
        	return 1;
        }

        int start = 1;
        int end = n;
        int middle;

        while(start+1 < end){
        	middle = start + (end-start)/2;
        	if (SVNRepo.isBadVersion(middle) == true){
        		end = middle;
        	}
        	else{
        		start = middle;
        	}
        }

        // A special case when all are bad versions we will have start == true and end == true
        if (SVNRepo.isBadVersion(start) == true && SVNRepo.isBadVersion(end) == true){
        	return start;
        }
        else{
        	return end;
        }
    }
}