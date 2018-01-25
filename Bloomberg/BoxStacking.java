/**
 *	Box Stacking:
 *	Given an array of boxes, one box can stack on top of another one only if both length and width are larger
 *  Find the maximum height by stacking these boxes
 */
class BoxStacking {

	/**
	 * Version 1: Can't rotate: sort the boxes by length, find the largest height ending at current box
	 *			  At every position, there're three situations to compare: 1. Only use current box's height;
	 *																	   2. Not use current box's height;
	 *																	   3. Use current box's height along with previous boxes;
	 *      Time: O(n^2)
	 *     Space: O(n)
	 */
	class Box {
		int length;
		int width;
		int height;

		public Box(int l, int w, int h) {
			this.length = l;
			this.width = w;
			this.height = h;
		}
	}

	public int boxStocking(List<Box> boxes) {
        if (boxes == null || boxes.size() == 0) {
            return 0;
        }

        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return b1.length - b2.length;
            }
        });

        int[] dp = new int[boxes.size()];
        dp[0] = boxes.get(0).height;
        for (int i = 1; i < dp.length; ++i) {
        
        	// Determine if only use current box's height or not use current box's height
            dp[i] = Math.max(boxes.get(i).height, dp[i - 1]);
            for (int j = i - 1; j >= 0; --j) {
                if (boxes.get(i).width > boxes.get(j).width) {
                    dp[i] = Math.max(dp[i], boxes.get(i).height + dp[j]);
                }
            }
        }

        return dp[dp.length - 1];
    }
}