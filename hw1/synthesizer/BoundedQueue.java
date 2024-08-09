package synthesizer;

public interface BoundedQueue<T>
{
	/**
	 * Returns the size of the buffer.
	 */
	int capacity();

	/**
	 * Returns number of items currently in the buffer.
	 */
	int fillCount();

	/**
	 * Adds item x to the end.
	 */
	void enqueue(T x);

	/**
	 * Deletes and returns the item from the front.
	 */
	T dequeue();

	/**
	 * Returns (but not delete) item from the front.
	 */
	T peek();

	/**
	 * Checks if the queue is empty
	 */
	default boolean isEmpty()
	{
		return fillCount() == 0;
	}

	/**
	 * Checks if the queue is full.
	 */
	default boolean isFull()
	{
		return fillCount() == capacity();
	}
}
