/**
 *	Maximum Population:
 *	Given some people's Year-of-Birth and Year-of-Death, return the year with maximum population.
 */
class MaximumPopulation {

	/**
	 * Version 1: Sort Year-of-Birth array and Year-of-Death array respectively;
     *            Traverse through these two arrays, population of each year can be obtain by substracting total death from total birth before that year;
     *            Update the maximum population and corresponding year during the traversal;
	 *      Time: O(nlogn) -> n is the number of people
	 *     Space: O(n)
	 */
	public int maxPopulation(int[][] dates) {
        if (dates == null || dates.length == 0) {
            return -1;
        }

        int[] birth = new int[dates.length];
        int[] dead = new int[dates.length];
        for (int i = 0; i < dates.length; ++i) {
            birth[i] = dates[i][0];
            dead[i] = dates[i][1];
        }

        Arrays.sort(birth);
        Arrays.sort(dead);

        int alive = 1;
        int maxAlive = 1;
        int result = birth[0];

        int i = 1;
        int j = 0;
        while (i < dates.length && j < dates.length) {
            if (birth[i] <= dead[j]) {
                ++alive;

                if (alive >= maxAlive) {
                    result = birth[i];
                }
                i++;
            } else {
                --alive;
                j++;
            }
        }

        return result;
    }

    /**
     * Version 2: Create an array to represent years between minYear and maxYear;
     *            For every year range, increment startYear by 1 and decrement (endYear + 1) by 1;
     *            Calculate cumulative sum of the array and update maximum population and its corresponding year;
     *      Time: O(n + m) -> n is the number of people
     *     Space: O(m) -> m is the difference of maximum year and mininum year
     */
    public int maxPopulation(int[][] dates) {
        if (dates == null || dates.length == 0 || dates[0].length == 0) {
            return -1;
        }

        int minYear = dates[0][0];
        int maxYear = dates[0][1];
        for (int[] date : dates) {
            minYear = Math.min(date[0], minYear);
            maxYear = Math.max(maxYear, date[1]);
        }

        int[] years = new int[maxYear - minYear + 1];
        for (int[] date : dates) {
            int start = date[0];
            int end = date[1];

            years[start - minYear] += 1;
            if (end != maxYear) {
                years[end - minYear] -= 1;
            }
        }

        int maxPopulation = years[0];
        int resultYear = minYear;

        for (int i = 1; i < years.length; ++i) {
            years[i] = years[i] + years[i - 1];
            if (years[i] > maxPopulation) {
                resultYear = minYear + i;
                maxPopulation = years[i];
            }
        }

        return resultYear;
    }
}