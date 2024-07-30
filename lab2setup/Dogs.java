public class Dogs
{
	private final int size;

	public Dogs(int s)
	{
		size = s;
	}

	/**
	 * Makes a noise.
	 */
	public String noise()
	{
		if (size < 10)
		{
			return "yip";
		}
		return "bark";
	}
}
