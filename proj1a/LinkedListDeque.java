public class LinkedListDeque<T>
{
	private final Node<T> sentinel;
	private int size;

	/**
	 * Constructor
	 */
	public LinkedListDeque()
	{
		size = 0;
		sentinel = new Node<>(null, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	/**
	 * Adds an element to the front of the list.
	 */
	public void addFirst(T item)
	{
		sentinel.next.prev = new Node<>(item, sentinel, sentinel.next);
		sentinel.next = sentinel.next.prev;
		size++;
	}

	/**
	 * Adds an element to the last of the list.
	 */
	public void addLast(T item)
	{
		sentinel.prev.next = new Node<>(item, sentinel.prev, sentinel);
		sentinel.prev = sentinel.prev.next;
		size++;
	}

	/**
	 * Checks if the list is empty.
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}

	/**
	 * Returns the size of the list.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Prints out the list.
	 */
	public void printDeque()
	{
		Node<T> p = sentinel.next;
		while (p != sentinel)
		{
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	/**
	 * Removes the first element in the list.
	 */
	public T removeFirst()
	{
		if (size > 0)
		{
			size--;
			T data = sentinel.next.data;
			sentinel.next = sentinel.next.next;
			sentinel.next.prev = sentinel;
			return data;
		}
		return null;
	}

	/**
	 * Removes the last element in the list.
	 */
	public T removeLast()
	{
		if (size > 0)
		{
			size--;
			T data = sentinel.prev.data;
			sentinel.prev = sentinel.prev.prev;
			sentinel.prev.next = sentinel;
			return data;
		}
		return null;
	}

	/**
	 * Gets the element at the index-th position iteratively.
	 */
	public T get(int index)
	{
		if (index < 0 || index >= size)
		{
			return null;
		}
		else
		{
			Node<T> p = sentinel.next;
			while (index > 0)
			{
				p = p.next;
				index--;
			}
			return p.data;
		}
	}

	/**
	 * Gets the index-th element in the list recursively.
	 */
	public T getRecursive(int index)
	{
		if (index < 0 || index >= size)
		{
			return null;
		}
		else
		{
			return sentinel.next.get(index);
		}
	}

	/**
	 * The Node that consists of the Deque
	 */
	private static class Node<T>
	{
		public T data;
		public Node<T> next;
		public Node<T> prev;

		/**
		 * The constructor of the Node class.
		 */
		public Node(T data, Node<T> prev, Node<T> next)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		/** The helper function that gets the index-th item in a naked DLList. */
		public T get(int index)
		{
			if (index == 0)
			{
				return data;
			}
			else
			{
				return next.get(index - 1);
			}
		}
	}
}
