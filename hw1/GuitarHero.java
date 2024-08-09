import javax.sound.midi.Synthesizer;
import javax.swing.text.StyledEditorKit;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar
 * string sound
 */
public class GuitarHero
{
	private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	private static final int KEYBOARD_NUM = keyboard.length();

	public static void main(String[] args)
	{
		synthesizer.GuitarString[] Strings = new synthesizer.GuitarString[37];
		for (int i = 0; i < KEYBOARD_NUM; i++)
		{
			Strings[i] = new synthesizer.GuitarString(440.0 * Math.pow(2.0, (double) (i - 24) / 12));
		}

		while (true)
		{
			if (StdDraw.hasNextKeyTyped())
			{
				char key = StdDraw.nextKeyTyped();
				int index = keyboard.indexOf(key);
				// System.out.println(index + ": " + key);
				if (index > 0)
				{
					Strings[index].pluck();
				}
			}

			double sample = 0;
			for (synthesizer.GuitarString string : Strings)
			{
				sample += string.sample();
				string.tic();
			}

			StdAudio.play(sample);
		}
	}
}
