import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestOffByN
{
	@Test
	public void testEqualChars()
	{
		OffByN offBy5 = new OffByN(5);
		assertTrue(offBy5.equalChars('a', 'f'));  // true
		assertTrue(offBy5.equalChars('f', 'a'));  // true
		assertFalse(offBy5.equalChars('f', 'h'));  // false
	}
}
