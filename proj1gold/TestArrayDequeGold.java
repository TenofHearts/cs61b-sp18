import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold
{

	@Test
	public void testFindError()
	{
		StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
		ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
		String msg = "";

		boolean passed = true;

		for (int i = 0; true; i++)
		{
			double p = StdRandom.uniform();
			if (p <= 0.25)
			{
				msg = msg.concat("addFirst(" + i + ")\n");
				student.addFirst(i);
				expected.addFirst(i);
			}
			else if (p <= 0.5)
			{
				msg = msg.concat("addLast(" + i + ")\n");
				student.addLast(i);
				expected.addLast(i);
			}
			else if (p <= 0.75)
			{
				if (!student.isEmpty() && !expected.isEmpty())
				{
					msg = msg.concat("removeFirst()\n");
					Integer s = student.removeFirst();
					Integer e = expected.removeFirst();
					assertEquals(msg, e, s);
				}
				else
				{
					msg = msg.concat("addFirst(" + i + ")\n");
					student.addFirst(i);
					expected.addFirst(i);
				}
			}
			else
			{
				if (!student.isEmpty() && !expected.isEmpty())
				{
					msg = msg.concat("removeLast()\n");
					Integer s = student.removeLast();
					Integer e = expected.removeLast();
					assertEquals(msg, e, s);
				}
				else
				{
					msg = msg.concat("addLast(" + i + ")\n");
					student.addLast(i);
					expected.addLast(i);
				}
			}
		}

	}
}
