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

	private static boolean isPalindrome(Deque<Character> word, CharacterComparator cc)
	{
		if (word.isEmpty() || word.size() == 1)
		{
			return true;
		}
		else
		{
			char first = word.removeFirst();
			char last = word.removeLast();
			if (cc.equalChars(first, last))
			{
				return Palindrome.isPalindrome(word, cc);
			}
			else
			{
				return false;
			}
		}
	}

	public Deque<Character> wordToDeque(String word)
	{
		Deque<Character> deque = new LinkedListDeque<Character>();
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

	public boolean isPalindrome(String word, CharacterComparator cc)
	{
		Deque<Character> word_deque = wordToDeque(word);
		return Palindrome.isPalindrome(word_deque, cc);
	}
}
