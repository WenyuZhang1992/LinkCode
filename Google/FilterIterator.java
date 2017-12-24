/**
 *	Filtered Iterator
 *	Implement a filtered iterator, when we iterate the Collection instance, only even integer elements are visited.
 */
public class FilterIterator implements Iterator<Integer>, Predicate<Integer> {

    Integer peek;
    Iterator<Integer> iter;

    public FilterIterator(Iterator<Integer> iterator) {
        peek = null;
        iter = iterator;
        while (iter.hasNext()) {
            Integer temp = iter.next();
            if (test(temp)) {
                peek = temp;
                break;
            }
        }
    }

    @Override
    public Integer next() {
        Integer result = peek;
        peek = null;
        while (iter.hasNext()) {
            Integer temp = iter.next();
            if (test(temp)) {
                peek = temp;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return peek != null;
    }

    @Override
    public boolean test(Integer input) {
        if (input.intValue() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}