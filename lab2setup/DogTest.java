import static org.junit.Assert.*;
import org.junit.Test;

public class DogTest
{
    @Test
    public void testSmall()
    {
        Dogs d = new Dogs(3);
        assertEquals("yip", d.noise());
    }

    @Test
    public void testLarge()
    {
        Dogs d = new Dogs(20);
        assertEquals("bark", d.noise());
    }
}
