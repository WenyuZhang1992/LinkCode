/**
 *	Reliable Jump:
 *	Given a function unreliableJump() which might increment or decrement member count by 1 each time it's called.
 *  Use this function to implement reliableJump() function which can only increment count by 1.
 */
class ReliableJump {

	private count = 0;

	public int unreliableJump() {
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            count--;
            return -1;
        } else {
            count++;
            return 1;
        }
    }

    /**
	 * Version 1: Recursive version
	 *      Time:
	 *     Space: O(1)
	 */
    public void reliableJump() {
        if (unreliableJump() == 1) {
            return;
        } else {
            reliableJump();
            reliableJump();
        }
    }

    /**
	 * Version 2: Iterative version
	 *      Time:
	 *     Space: O(1)
	 */
    public void reliableJump() {
        int decreCount = 0;
        int increCount = 0;

        while (increCount - decreCount != 1) {
            if (unreliableJump() == 1) {
                ++increCount;
            } else {
                ++decreCount;
            }
        }
    }
}