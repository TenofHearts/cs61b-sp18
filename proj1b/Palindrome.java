import java.util.ArrayDeque;

public class Palindrome
{
	private static boolean isPalindrome(Deque<Character> word)
	{
		if (word.isEmpty() || word.size() == 1)
		{
			return true;
		}
		else
		{
			Character first = word.removeFirst();
			Character last = word.removeLast();
			if (first.charValue() == last.charValue())
			{
				return Palindrome.isPalindrome(word);
			}
			else
			{
				return false;
			}
		}
	}

	public Deque<Character> wordToDeque(String word)
	{
		Deque<Character> deque = new LinkedListDeque<>();
		for (int i = 0; i < word.length(); i++)
		{
			deque.addLast(word.charAt(i));
		}
		return deque;
	}

	public boolean isPalindrome(String word)
	{
		Deque<Character> word_deque = wordToDeque(word);
		return Palindrome.isPalindrome(word_deque);
	}
}
