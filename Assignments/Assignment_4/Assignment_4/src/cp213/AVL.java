package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 *
 * @author your name here
 * @author Name
 * @version 2023-11-20
 */
public class AVL<T extends Comparable<T>> extends BST<T> {

    /**
     * Returns the balance item of node. If greater than 1, then left heavy, if less
     * than -1, then right heavy. If in the range -1 to 1 inclusive, the node is
     * balanced. Used to determine whether to rotate a node upon insertion.
     *
     * @param node The TreeNode to analyze for balance.
     * @return A balance number.
     */
    private int balance(final TreeNode<T> node) {

	if (node == null) {
	    return 0;
	}
	int leftHeight;
	int rightHeight;
	if (node.getLeft() == null) {
	    leftHeight = 1;
	} else {
	    leftHeight = node.getLeft().getHeight() + 1;
	}

	if (node.getRight() == null) {
	    rightHeight = 1;
	} else {
	    rightHeight = node.getRight().getHeight() + 1;
	}

	return leftHeight - rightHeight;
    }

    /**
     * Rebalances the current node if its children are not balanced.
     *
     * @param node the node to rebalance
     * @return replacement for the rebalanced node
     */
    private TreeNode<T> rebalance(TreeNode<T> node) {
	// your code here
	return null;
    }

    /**
     * Performs a left rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateLeft(final TreeNode<T> node) {
	TreeNode<T> pivot = node.getRight();
	node.setRight(pivot.getLeft());
	pivot.setLeft(node);
	pivot.updateHeight();
	node.updateHeight();
	return pivot;
    }

    /**
     * Performs a right rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> node) {
	TreeNode<T> pivot = node.getLeft();
	node.setLeft(pivot.getRight());
	pivot.setRight(node);
	pivot.updateHeight();
	node.updateHeight();

	return pivot;
    }

    /**
     * Auxiliary method for insert. Inserts data into this AVL.
     *
     * @param node The current node (TreeNode).
     * @param data Data to be inserted into the node.
     * @return The inserted node.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedItem<T> data) {
	if (node == null) {
	    TreeNode<T> new_node = new TreeNode<T>(data);
	    this.size++;
	    new_node.getdata().incrementCount();
	    return new_node;
	} else if (data.compareTo(node.getdata()) > 0) {
	    node.setRight(insertAux(node.getRight(), data));
	} else if (data.compareTo(node.getdata()) < 0) {
	    node.setLeft(insertAux(node.getLeft(), data));
	} else {
	    node.getdata().incrementCount();
	    return node;
	}
	node.updateHeight();
	return rotateNode(node);
    }

    private TreeNode<T> rotateNode(TreeNode<T> node) {
	int balance = balance(node);
	if (balance > 1) {
	    if (balance(node.getLeft()) < 0) {
		node.setLeft(rotateLeft(node.getLeft()));
	    }
	    return rotateRight(node);
	} else if (balance < -1) {
	    if (balance(node.getRight()) > 0) {
		node.setRight(rotateRight(node.getRight()));
	    }
	    return rotateLeft(node);
	}
	return node;
    }

    /**
     * Auxiliary method for valid. Determines if a subtree based on node is a valid
     * subtree. An AVL must meet the BST validation conditions, and additionally be
     * balanced in all its subtrees - i.e. the difference in height between any two
     * children must be no greater than 1.
     *
     * @param node The root of the subtree to test for validity.
     * @return true if the subtree base on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {
	if (node == null) {
	    return true;
	} else if (minNode != null) {
	    if (minNode.getdata().compareTo(node.getdata()) > 0) {
		return false;
	    }
	} else if (maxNode != null) {
	    if (maxNode.getdata().compareTo(node.getdata()) < 0) {
		return false;
	    }
	}
	return isValidAux(node.getLeft(), minNode, node) && isValidAux(node.getRight(), node, maxNode);
    }

    /**
     * Determines whether two AVLs are identical.
     *
     * @param target The AVL to compare this AVL against.
     * @return true if this AVL and target contain nodes that match in position,
     *         item, count, and height, false otherwise.
     */
    public boolean equals(final AVL<T> target) {
	return super.equals(target);
    }

}
