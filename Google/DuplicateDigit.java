/**
 *  Given an integer, you're allowed to duplicate only one digit,
 *  Return the maximum of the duplicated values
 *
 *  Example:
 *  12345 -> return 1223455
 */
class DuplicateDigit {

    /**
     * Version 1: Traverse through the digits and find the first descreasing slope
     *      Time: O(n)
     *     Space: O(n)
     */
    public int duplicateNumber(int num){
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while (num > 0) {
            digits.add(0, num % 10);
            num /= 10;
        }
        if (digits.size() == 1) {
            return digits.get(0) * 11;
        }

        int[] result = new int[digits.size() + 1];
        int i = 0;
        int j = 0;
        while (i < digits.size() - 1) {
            if (digits.get(i) <= digits.get(i + 1)) {
                result[j++] = digits.get(i++);
            } else {
                result[j++] = digits.get(i);
                while (j < digits.size()) {
                    result[j++] = digits.get(i++);
                }
                return getIntValue(result);
            }
        }

        result[j] = digits.get(digits.size() - 1);
        result[j + 1] = result[j];
        return getIntValue(result);
    }

    private int getIntValue(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result * 10 + num;
        }

        return result;
    }
}