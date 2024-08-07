import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome
{
	// You must use this palindrome, and not instantiate
	// new Palindromes, or the autograder might be upset.
	static Palindrome palindrome = new Palindrome();

	@Test
	public void testWordToDeque()
	{
		Deque d = palindrome.wordToDeque("persiflage");
		String actual = "";
		for (int i = 0; i < "persiflage".length(); i++)
		{
			actual += d.removeFirst();
		}
		assertEquals("persiflage", actual);
	}

	@Test
	public void testIsPalindrome()
	{
		assertTrue(palindrome.isPalindrome("abba"));
		assertTrue(palindrome.isPalindrome("a"));
		assertTrue(palindrome.isPalindrome(""));
		assertFalse(palindrome.isPalindrome("horse"));

		OffByOne offByOne = new OffByOne();
		assertTrue(palindrome.isPalindrome("abab", offByOne));
		assertTrue(palindrome.isPalindrome("c", offByOne));
		assertTrue(palindrome.isPalindrome("", offByOne));
		assertFalse(palindrome.isPalindrome("abba", offByOne));
	}
}
