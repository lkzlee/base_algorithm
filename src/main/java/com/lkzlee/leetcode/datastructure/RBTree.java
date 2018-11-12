package com.lkzlee.leetcode.datastructure;

/***
 * @author:lkzlee
 * @date: 2018/11/12 14:53
 * @Desc:
 * 红黑树的特点：
 *
 * 1.每个节点颜色不是黑色就是红色
 * 2.根节点总是黑色，叶子节点都是黑的。
 * 3.如果节点是红色，则它的字节点必须是黑色（反之不一定）
 * 4.从根节点到叶子节点或空节点的每条路径包含相同数目的黑色节点，即相同的黑色高度。
 */
public class RBTree<T extends Comparable<T>>
{

	private RBNode<T> root;
	private final static boolean RED = false;
	private final static boolean BLACK = true;

	/***
	 * 左旋示意图：对节点x进行左旋
	 *     p                       p
	 *    /                       /
	 *   x                       y
	 *  / \                     / \
	 * lx  y      ----->       x  ry
	 *    / \                 / \
	 *   ly ry               lx ly
	 *
	 * 左旋做三件事情：
	 * 1.将y的的左字节点ly，赋给x的的右子节点，并将x赋给y的左子节点（y的左字节点为空时）
	 * 2.将x的父节点p（非空时）赋给y的父节点，同时更新p的子节点为y（左或右）
	 * 3.将y的左子节点设为x，将x的父节点设为y
	 * @param x
	 */
	private void leftRotate(RBNode<T> x)
	{
		//1.将y的的左字节点ly，赋给x的的右子节点，并将x赋给y的左子节点（y的左字节点为空时）

		RBNode y = x.right;
		x.right = y.left;
		if (y.left != null)
			y.left.parent = x;

		//2.将x的父节点p（非空时）赋给y的父节点，同时更新p的子节点为y（左或右）
		y.parent = x.parent;

		if (x.parent == null)
			this.root = y;
		else
		{
			if (x == x.parent.left)
				x.parent.left = y;
			else
				x.parent.right = y;
		}
		//3.将y的左子节点设为x，将x的父节点设为y
		y.left = x;
		x.parent = x;
	}

	/*
	 * 左旋示意图：对节点y进行右旋
	 *        p                   p
	 *       /                   /
	 *      y                   x
	 *     / \                 / \
	 *    x  ry   ----->      lx  y
	 *   / \                     / \
	 * lx  rx                   rx ry
	 * 右旋做了三件事：
	 * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
	 * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
	 * 3. 将x的右子节点设为y，将y的父节点设为x
	 */
	private void rightRotate(RBNode<T> y)
	{

		//1.将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
		RBNode<T> x = y.left;
		y.left = x.right;

		if (x.right != null)
			x.right.parent = y;

		//2.将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)//
		x.parent = y.parent;

		if (y.parent == null)
			this.root = x;
		else
		{
			if (y == y.parent.right)
				y.parent.right = x;
			else
				y.parent.left = x;
		}

		//3.将y的左子节点设为x，将x的父节点设为y
		x.right = y;
		y.parent = x;
	}

	public void insert(T key)
	{
		RBNode<T> node = new RBNode<T>(RED, key, null, null, null);
		if (node != null)
			insertNode(node);
	}

	public RBNode<T> search(T key)
	{
		return search(this.root, key);
	}

	private RBNode<T> search(RBNode<T> x, T key)
	{
		while (x != null)
		{
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x;
		}
		return x;
	}

	public T minValue()
	{
		RBNode<T> node = minNode(this.root);
		if (node != null)
			return node.key;
		return null;
	}

	public RBNode<T> minNode(RBNode<T> tree)
	{
		if (tree == null)
			return null;
		while (tree.left != null)
		{
			tree = tree.left;
		}
		return tree;
	}

	public T maxValue()
	{
		RBNode<T> node = maxNode(this.root);
		if (node != null)
			return node.key;
		return null;
	}

	public RBNode<T> maxNode(RBNode<T> tree)
	{
		if (tree == null)
			return null;
		while (tree.right != null)
		{
			tree = tree.right;
		}
		return tree;
	}

	/***
	 * 将节点插入红黑树中，这个过程与二叉搜索树一样
	 * @param node
	 */
	private void insertNode(RBNode<T> node)
	{
		RBNode<T> current = null;
		RBNode<T> x = this.root;
		//1.找到插入位置
		while (x != null)
		{
			current = x;
			int cmp = node.key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else
				x = x.right;
		}
		node.parent = current;
		//2.接下来判断node是插入左子树 还是右子树
		if (current != null)
		{
			int cmp = node.key.compareTo(current.key);
			if (cmp < 0)
				current.left = node;
			else
				current.right = node;
		}
		else
		{
			this.root = node;
		}
		//3.将它调整为一颗红黑树
		insertFixUp(node);
	}

	private void insertFixUp(RBNode<T> node)
	{
		RBNode<T> parent, gparent;

		while ((parent = parentOf(node)) != null && isRed(parent))
		{
			gparent = parentOf(parent);

			if (parent == gparent.left)
			{

				RBNode<T> uncle = gparent.right;
				//1叔叔节点也是红色
				if (uncle != null && isRed(uncle))
				{
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					node = gparent;
					continue;
				}
				//2. 叔叔节点是黑色，且为当前右子节点
				if (node == parent.right)
				{
					leftRotate(parent);
					RBNode<T> tmp = parent;
					parent = node;
					node = tmp;
				}
				//3.叔叔节点是黑色，且当前节点是左节点
				setBlack(parent);
				setRed(gparent);
				rightRotate(gparent);
			}
			else
			{
				RBNode<T> uncle = gparent.left;

				//1. 叔叔节点是红色
				if (uncle != null && isRed(uncle))
				{
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					node = gparent;
					continue;
				}
				//2.叔叔节点是黑色，且为当前左子节点
				if (node == parent.left)
				{
					rightRotate(parent);
					RBNode<T> tmp = parent;
					parent = node;
					node = tmp;
				}
				//3.叔叔节点是黑色，且当前为右字节点
				setBlack(parent);
				setRed(gparent);
				leftRotate(gparent);
			}
		}
		setBlack(this.root);
	}

	private boolean isRed(RBNode<T> node)
	{
		return node.color == RED;
	}

	private RBNode<T> parentOf(RBNode<T> node)
	{
		return node == null ? null : node.parent;
	}

	public void setBlack(RBNode<T> node)
	{
		node.color = BLACK;
	}

	public void setRed(RBNode<T> node)
	{
		node.color = RED;
	}
}
