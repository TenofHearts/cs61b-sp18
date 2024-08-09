package synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer
{
	/** Calls tests for ArrayRingBuffer. */
	public static void main(String[] args)
	{
		jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
	}

	@Test
	public void someTest()
	{
		ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);

		assertTrue(arb.isEmpty());
		arb.enqueue(1);
		arb.enqueue(2);
		assertEquals(1, arb.dequeue().intValue());
		arb.enqueue(3);
		arb.enqueue(4);
		arb.enqueue(5);
		assertTrue(arb.isFull());
		assertEquals(2, arb.dequeue().intValue());
		assertFalse(arb.isFull());
		assertFalse(arb.isEmpty());
	}

	@Test
	public void forTest()
	{
		ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);

		for (int i = 0; i < 4; i++)
		{
			arb.enqueue(i);
		}

		int answer = 0;
		for (Integer n : arb)
		{
			assertEquals(answer++, n.intValue());
		}
	}
}