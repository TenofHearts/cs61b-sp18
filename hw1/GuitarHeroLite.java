import javax.sound.midi.Synthesizer;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar
 * string sound
 */
public class GuitarHeroLite
{
	private static final double CONCERT_A = 440.0;
	private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

	public static void main(String[] args)
	{
		/* create two guitar strings, for concert A and C */
		hw1.synthesizer.GuitarString stringA = new hw1.synthesizer.GuitarString(CONCERT_A);
		hw1.synthesizer.GuitarString stringC = new hw1.synthesizer.GuitarString(CONCERT_C);

		while (true)
		{

			/* check if the user has typed a key; if so, process it */
			if (StdDraw.hasNextKeyTyped())
			{
				char key = StdDraw.nextKeyTyped();
				if (key == 'a')
				{
					stringA.pluck();
				}
				else if (key == 'c')
				{
					stringC.pluck();
				}
			}

			/* compute the superposition of samples */
			double sample = stringA.sample() + stringC.sample();

			/* play the sample on standard audio */
			StdAudio.play(sample);

			/* advance the simulation of each guitar string by one step */
			stringA.tic();
			stringC.tic();
		}
	}
}
