package multisets;

import es.upm.aedlib.Pair;
import es.upm.aedlib.positionlist.PositionList;

/**
 * Defines the methods a multiset provides, i.e., a data structure similar to a
 * set except that elements may occur multiple times. For example, {1,2,3,1} is
 * a multiset, but not a set, since 1 occurs twice.
 */
public interface MultiSet<Element> {

	/**
	 * Adds an element n times to the multiset.
	 *
	 * @param elem the element to add; note that <code>null</code> arguments are
	 *             permitted.
	 * @throws IllegalArgumentException if n<0.
	 */
	public void add(Element elem, int n);

	/**
	 * Removes n copies of an element from the multiset.
	 *
	 * @param elem the element to remove. Note that <code>null</code> is permitted
	 *             as an argument
	 * @throws IllegalArgumentException if n<0 or if there are fewer than n copies
	 *                                  of elem in the set.
	 */
	public void remove(Element elem, int n);

	/**
	 * Counts the number of occurrences of an element in the multiset.
	 *
	 * @param elem the element to count. Note that <code>null</code> is permitted as
	 *             an argument
	 * @return the number of occurences of the element in the multiset
	 */
	public int count(Element elem);

	/**
	 * Returns the number of elements in the multiset.
	 *
	 * @return the number of elements in the multiset
	 */
	public int size();

	/**
	 * Checks if the multiset is empty.
	 *
	 * @return true if the multiset is empty, and false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Return a positionlist containing all elements of the multiset.
	 * 
	 * @return a positionlist containing all elements of the multiset.
	 */
	public PositionList<Element> allElements();

	/**
	 * Returns a new multiset corresponding to the "intersection" of the object
	 * multiset, and the argument multiset.
	 * 
	 * @return the multiset corresponding to the intersection of the multisets.
	 */
	public MultiSet<Element> intersection(MultiSet<Element> s);

	/**
	 * Returns a new multiset corresponding to the "sum" of the object multiset, and
	 * the argument multiset.
	 * 
	 * @return the multiset corresponding to the sum of the multisets.
	 */
	public MultiSet<Element> sum(MultiSet<Element> s);

	/**
	 * Returns a new multiset corresponding to the removal of the elements in the
	 * argument from the object multiset.
	 * 
	 * @return the multiset corresponding to the subtraction of the multisets.
	 */
	public MultiSet<Element> minus(MultiSet<Element> s);
}
