/**
 *	Box Stacking:
 *	Given an array of boxes, one box can stack on top of another one only if both length and width are larger
 *  Find the maximum height by stacking these boxes
 */
class BoxStacking {

	/**
	 * Version 1: Can't rotate: sort the boxes by length, find the largest height ending at current box
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
	public int boxStacking(Box[] boxes) {
		if (boxes == null || boxes.length == 0) {
			return Integer.MIN_VALUE;
		}

		Arrays.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box b1, Box b2) {
				return b1.length - b2.length;
			}
		});

		int[] dp = new int[boxes.length];
		dp[0] = boxes[0].height;
		int result = Integer.MIN_VALUE;

		for (int i = 1; i < boxes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (boxes[i].width > boxes[j].width) {
					dp[i] = Math.max(dp[i], dp[j] + boxes[i].depth);
				}
			}
			result = Math.max(result, dp[i]);
		}

		return result;
	}
}