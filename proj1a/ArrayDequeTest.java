/** Performs some basic array tests. */
public class ArrayDequeTest
{

	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual)
	{
		if (expected != actual)
		{
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual)
	{
		if (expected != actual)
		{
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkEquals(String expected, String actual)
	{
		if (!expected.equals(actual))
		{
			System.out.println("returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkEquals(int expected, int actual)
	{
		if (expected != actual)
		{
			System.out.println("returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed.
	 * The \n means newline. */
	public static void printTestStatus(boolean passed)
	{
		if (passed)
		{
			System.out.println("Test passed!\n");
		}
		else
		{
			System.out.println("Test failed!\n");
		}
	}

	/**
	 * Adds a few things to the list, checking isEmpty() and size() are correct,
	 * finally printing the results.
	 * <p>
	 * && is the "and" operation.
	 */
	public static void addIsEmptySizeTest()
	{
		System.out.println("Running add/isEmpty/Size test.");
		ArrayDeque<String> lld1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest()
	{

		System.out.println("Running add/remove test.");
		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
	}

	/** Checks that the two get methods return the same correct result. */
	public static void getGetRecursiveTest()
	{
		System.out.println("Running get/getRecursive test.");
		ArrayDeque<String> lld1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		lld1.addLast("middle");
		lld1.addLast("back");

		passed = checkEquals("back", lld1.get(2)) && passed;
		passed = checkEquals("front", lld1.get(0)) && passed;
		passed = checkEquals("middle", lld1.get(1)) && passed;

		printTestStatus(passed);

	}

	/** Checks that the resizing is correct. */
	public static void resizeTest()
	{
		System.out.println("Running resize test.");
		ArrayDeque<Integer> lst = new ArrayDeque<>();

		boolean passed = checkEmpty(true, lst.isEmpty());

		for (int i = 0; i < 10000; i++)
		{
			lst.addLast(i);
		}
		passed = checkEquals(12, lst.get(12)) && passed;
		passed = checkEquals(41, lst.get(41)) && passed;
		passed = checkEquals(10, lst.get(10)) && passed;
		passed = checkEquals(1004, lst.get(1004)) && passed;
		passed = checkEquals(4110, lst.get(4110)) && passed;

		for (int i = 0; i < 9999; i++)
		{
			lst.removeFirst();
		}

		passed = checkEquals(9999, lst.get(0)) && passed;
		passed = checkEquals(1, lst.size()) && passed;

		lst.removeLast();
		passed = checkEmpty(true, lst.isEmpty()) && passed;

		printTestStatus(passed);
	}

	public static void main(String[] args)
	{
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		getGetRecursiveTest();
		resizeTest();
	}
} 