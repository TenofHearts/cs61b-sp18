public class ArrayDeque<T>
{
	private int size;
	private T[] arr;
	private int head;
	private int tail;

	/**
	 * Constructor
	 */
	public ArrayDeque()
	{
		size = 0;
		arr = (T[]) new Object[8];
		head = 7;
		tail = 0;
	}

	private void resize(int capacity)
	{
		T[] newArr = (T[]) new Object[capacity];
		int newHead = newArr.length - 1;
		int newTail = size;
		for (int i = 0; i < size; i++)
		{
			newArr[i] = arr[(head + 1 + i) % size];
		}

		arr = newArr;
		head = newHead;
		tail = newTail;
	}

	/**
	 * Adds an element to the front of the list.
	 */
	public void addFirst(T item)
	{
		if (size == arr.length)
		{
			resize(size * 2);
		}
		arr[head] = item;
		head = (head - 1 + arr.length) % arr.length;
		size++;
	}

	/**
	 * Adds an element to the last of the list.
	 */
	public void addLast(T item)
	{
		if (size == arr.length)
		{
			resize(size * 2);
		}
		arr[tail] = item;
		tail = (tail + 1) % arr.length;
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
		for (int i = 0; i < size; i++)
		{
			System.out.print(arr[(head + 1 + i) % arr.length] + " ");
		}
		System.out.println();
	}

	/**
	 * Removes the first element in the list.
	 */
	public T removeFirst()
	{
		head = (head + 1) % arr.length;
		T item = arr[head];
		arr[head] = null;
		size--;
		if ((double) size / (double) arr.length < 0.25)
		{
			resize(arr.length / 2);
		}
		return item;
	}

	/**
	 * Removes the last element in the list.
	 */
	public T removeLast()
	{
		tail = (tail - 1 + arr.length) % arr.length;
		T item = arr[tail];
		arr[tail] = null;
		size--;
		if ((double) size / (double) arr.length < 0.25)
		{
			resize(arr.length / 2);
		}
		return item;
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
			return arr[(head + 1 + index) % arr.length];
		}
	}
}
