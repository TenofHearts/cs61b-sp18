package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame
{
	private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!", "You got this!", "You're a star!", "Go Bears!", "Too easy for you!", "Wow, so impressive!"};
	private int width;
	private int height;
	private int round;
	private Random rand;
	private boolean gameOver;
	private boolean playerTurn;

	public MemoryGame(int width, int height, int seed)
	{
		/* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
		 * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
		 */
		this.width = width;
		this.height = height;
		StdDraw.setCanvasSize(this.width * 16, this.height * 16);
		Font font = new Font("0xProto Nerd Font", Font.BOLD, 30);
		StdDraw.setFont(font);
		StdDraw.setXscale(0, this.width);
		StdDraw.setYscale(0, this.height);
		StdDraw.clear(Color.BLACK);
		StdDraw.enableDoubleBuffering();

		//TODO: Initialize random number generator
		rand = new Random(seed);
	}

	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Please enter a seed");
			return;
		}

		int seed = Integer.parseInt(args[0]);
		MemoryGame game = new MemoryGame(40, 40, seed);
		game.startGame();
	}

	public String generateRandomString(int n)
	{
		//TODO: Generate random string of letters of length n
		String str = "";
		for (int i = 0; i < n; i++)
		{
			char ch = CHARACTERS[rand.nextInt(CHARACTERS.length)];
			str = str.concat(String.valueOf(ch));
		}
		return str;
	}

	public void drawFrame(String s)
	{
		//TODO: Take the string and display it in the center of the screen
		StdDraw.clear();


		StdDraw.setPenColor(100, 0, 255);
		StdDraw.text(20.0, 20.0, s);

		StdDraw.show();

		//TODO: If game is not over, display relevant game information at the top of the screen
	}

	public void flashSequence(String letters)
	{
		//TODO: Display each character in letters, making sure to blank the screen between letters
		char[] letter = letters.toCharArray();
		for (char ch : letter)
		{
			drawFrame(String.valueOf(ch));
			StdDraw.pause(1000);
			StdDraw.clear();
			StdDraw.pause(500);
		}
	}

	public String solicitNCharsInput(int n)
	{
		//TODO: Read n letters of player input
		String str = "";
		for (int i = 0; i < n; i++)
		{
			boolean flag = false;
			while (!flag)
			{
				flag = StdDraw.hasNextKeyTyped();
			}

			char ch = StdDraw.nextKeyTyped();
			str = str.concat(String.valueOf(ch));
			drawFrame(str);
		}
		return str;
	}

	public void startGame()
	{
		//TODO: Set any relevant variables before the game starts
		round = 0;
		gameOver = false;

		//TODO: Establish Game loop
		while (!gameOver)
		{
			round++;
			drawFrame("Round: %d".formatted(round));
			StdDraw.pause(1000);
			playerTurn = false;

			String target = generateRandomString(round);
			flashSequence(target);
			playerTurn = true;
			String get = solicitNCharsInput(round);

			gameOver = !target.equals(get);
		}
		drawFrame("Game Over! You made it to round: %d".formatted(round));
		StdDraw.pause(3000);
	}

}
