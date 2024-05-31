package cp213;

import java.util.ArrayList;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author Name
 * @version 2023-10-26
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The value to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {

	SingleNode<T> previousNode_Pointer = this.front;

	int i = 1;

	while ((previousNode_Pointer.getItem().compareTo(key) != 0) && (i < this.length)) {
	    previousNode_Pointer = previousNode_Pointer.getNext();
	    i++;
	}

	if (previousNode_Pointer.getItem().compareTo(key) != 0) {
	    previousNode_Pointer = null;
	}

	return previousNode_Pointer;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param data The value to append.
     */
    public void append(final T data) {

	SingleNode<T> appendNode = new SingleNode<T>(data, null);

	if (this.rear != null)
	    this.rear.setNext(appendNode);

	this.rear = appendNode;

	if (this.front == null) {
	    this.front = appendNode;
	}

	this.length++;

	return;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each value formerly present in this SingleList. The first occurrence of
     * each value is preserved.
     */
    public void clean() {

	SingleNode<T> currentNode = this.front;

	SingleNode<T> previousNode = this.front;

	ArrayList<T> arrL = new ArrayList<T>();

	int i = 0;

	while (i < this.length) {
	    if (arrL.contains(currentNode.getItem())) {
		previousNode.setNext(currentNode.getNext());
		if (currentNode == this.rear) {
		    this.rear = previousNode;
		}
		currentNode = currentNode.getNext();
		this.length--;
	    } else {
		arrL.add(currentNode.getItem());
		previousNode = currentNode;
		currentNode = currentNode.getNext();
		i++;
	    }
	}

	return;
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

	while ((left.length > 0) || (right.length > 0)) {
	    if (left.length > 0) {
		this.moveFrontToRear(left);
	    }

	    if (right.length > 0) {
		this.moveFrontToRear(right);
	    }
	}

	return;
    }

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key value to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

	SingleNode<T> returnNode = this.linearSearch(key);

	boolean key_found = false;

	if (returnNode != null) {
	    key_found = true;
	}

	return key_found;

    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The value to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

	int count = 0;

	if (this.length > 0) {
	    SingleNode<T> currentNode = this.front;

	    int i = 0;

	    while (i < this.length) {
		if (currentNode.getItem().compareTo(key) == 0) {
		    count++;
		}
		currentNode = currentNode.getNext();
		i++;
	    }
	}

	return count;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {

	SingleNode<T> returnNode = this.linearSearch(key);

	T value = returnNode == null ? null : returnNode.getItem();

	// returns the value that matches the key
	return value;
    }

    /**
     * Get the nth item in this SingleList.
     *
     * @param n The index of the item to return.
     * @return The nth item in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

	int i = 0;

	SingleNode<T> returnNode = this.front;

	while (i < n) {
	    returnNode = returnNode.getNext();
	    i++;
	}

	return returnNode.getItem();

    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same values in the same order as
     *         source, false otherwise.
     */
    public boolean identical(final SingleList<T> source) {

	boolean identicals = true;

	if (this.length != source.length) {
	    identicals = false;
	} else {
	    int i = 0;

	    SingleNode<T> currentNode = this.front;

	    SingleNode<T> sourceNode = source.front;

	    while ((i < this.length) && (identicals)) {
		if (currentNode.getItem().compareTo(sourceNode.getItem()) != 0) {
		    identicals = false;
		}
		currentNode = currentNode.getNext();
		sourceNode = sourceNode.getNext();
		i++;
	    }
	}

	return identicals;
    }

    /**
     * Finds the first location of a value by key in this SingleList.
     *
     * @param key The value to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {

	SingleNode<T> returnNode = this.front;

	int i = 0;

	while ((returnNode.getItem().compareTo(key) != 0) && (i < this.length - 1)) {
	    returnNode = returnNode.getNext();
	    i++;
	}

	if (this.length > 0) {
	    if (returnNode.getItem().compareTo(key) != 0) {
		i = -1;
	    }
	}

	return i;
    }

    /**
     * Inserts value into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i    The index to insert the new data at.
     * @param data The new value to insert into this SingleList.
     */
    public void insert(int i, final T data) {

	SingleNode<T> node = new SingleNode<T>(data, null);

	if (this.length <= i) {

	    if (this.rear == null) {
		this.front = node;
		this.rear = node;
	    } else {
		this.rear.setNext(node);
		this.rear = node;
	    }

	} else if (i == 0) {
	    node.setNext(this.front);
	    this.front = node;
	} else {

	    SingleNode<T> currentNode = this.front;

	    for (int index = 1; index < i; index++) {
		currentNode = currentNode.getNext();
	    }

	    node.setNext(currentNode.getNext());
	    currentNode.setNext(node);
	}

	this.length++;

	return;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then values from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {

	SingleNode<T> leftNode = left.front;

	for (int i = 0; i < left.length; i++) {
	    if (right.contains(leftNode.getItem())) {
		this.append(leftNode.getItem());
	    }
	    leftNode = leftNode.getNext();
	}

	return;
    }

    /**
     * Finds the maximum value in this SingleList.
     *
     * @return The maximum value.
     */
    public T max() {

	T maxValue = this.front.getItem();

	SingleNode<T> currentNode = this.front;

	for (int i = 0; i < this.length; i++) {
	    if (currentNode.getItem().compareTo(maxValue) > 0) {
		maxValue = currentNode.getItem();
	    }

	    currentNode = currentNode.getNext();
	}

	return maxValue;
    }

    /**
     * Finds the minimum value in this SingleList.
     *
     * @return The minimum value.
     */
    public T min() {

	T minValue = this.front.getItem();

	SingleNode<T> currentNode = this.front;

	for (int i = 0; i < this.length; i++) {
	    if (currentNode.getItem().compareTo(minValue) < 0) {
		minValue = currentNode.getItem();
	    }

	    currentNode = currentNode.getNext();
	}

	return minValue;
    }

    /**
     * Inserts value into the front of this SingleList.
     *
     * @param data The value to insert into the front of this SingleList.
     */
    public void prepend(final T data) {

	SingleNode<T> currentnode = new SingleNode<T>(data, this.front);

	this.front = currentnode;

	if (this.rear == null) {
	    this.rear = this.front;
	}

	this.length++;

	return;
    }

    /**
     * Finds, removes, and returns the value in this SingleList that matches key.
     *
     * @param key The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {

	SingleNode<T> returnNode = this.front;

	SingleNode<T> previousNode = this.front;

	T value;

	int i = 1;

	while ((returnNode.getItem().compareTo(key) != 0) && (i < this.length)) {
	    previousNode = returnNode;
	    returnNode = returnNode.getNext();
	    i++;
	}

	if (returnNode != null) {
	    if (returnNode.getItem().compareTo(key) != 0) {
		returnNode = null;
	    } else {
		if (returnNode == this.front) {
		    this.front = this.front.getNext();
		} else {
		    previousNode.setNext(returnNode.getNext());
		}
		this.length--;
		if (this.length == 0) {
		    this.front = null;
		    this.rear = null;
		}
	    }
	}

	value = returnNode == null ? null : returnNode.getItem();

	return value;
    }

    /**
     * Removes the value at the front of this SingleList.
     *
     * @return The value at the front of this SingleList.
     */
    public T removeFront() {

	SingleNode<T> returnNode = this.front;

	this.front = this.front.getNext();

	this.length--;

	if (this.length == 0) {
	    this.rear = null;
	}

	return returnNode.getItem();
    }

    /**
     * Finds and removes all values in this SingleList that match key.
     *
     * @param key The value to search for.
     */
    public void removeMany(final T key) {

	SingleNode<T> currentNode = this.front;

	SingleNode<T> previousNode = this.front;

	int i = 0;

	while (i < this.length) {
	    if (currentNode.getItem().compareTo(key) == 0) {
		if (currentNode == this.front) {
		    this.front = this.front.getNext();
		    currentNode = this.front;
		} else {
		    previousNode.setNext(currentNode.getNext());
		    if (currentNode == this.rear) {
			this.rear = previousNode;
		    }
		    currentNode = currentNode.getNext();
		}
		this.length--;
	    } else {
		previousNode = currentNode;
		currentNode = currentNode.getNext();
		i++;
	    }
	}

	if (this.front == null) {
	    this.rear = null;
	}

	return;
    }

    /**
     * Reverses the order of the values in this SingleList.
     */
    public void reverse() {

	SingleNode<T> currentNode = this.front;

	SingleNode<T> previousNode = null;

	SingleNode<T> nextNode;

	for (int i = 0; i < this.length; i++) {
	    nextNode = currentNode.getNext();
	    currentNode.setNext(previousNode);
	    previousNode = currentNode;
	    currentNode = nextNode;
	}

	nextNode = this.front;

	this.front = this.rear;

	this.rear = nextNode;

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * item than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

	int splitValue = (this.length / 2);

	while (this.length > 0) {
	    if (this.length > splitValue) {
		left.moveFrontToRear(this);
	    } else {
		right.moveFrontToRear(this);
	    }
	}

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

	while (this.length > 0) {
	    left.moveFrontToRear(this);

	    if (this.length > 0) {
		right.moveFrontToRear(this);
	    }
	}

	return;
    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies value
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then values from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {

	SingleNode<T> leftNode = left.front;
	SingleNode<T> rightNode = right.front;

	for (int i = 0; i < left.length; i++) {
	    this.append(leftNode.getItem());
	    leftNode = leftNode.getNext();
	}

	for (int i = 0; i < right.length; i++) {
	    this.append(rightNode.getItem());
	    rightNode = rightNode.getNext();
	}

	return;
    }
}
