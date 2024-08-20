package byog.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld
{
	private static final int HEIGHT = 60;
	private static final int WIDTH = 60;

	public static void main(String[] args)
	{
		TERenderer renderer = new TERenderer();
		renderer.initialize(WIDTH, HEIGHT);

		TETile[][] world = new TETile[WIDTH][HEIGHT];
		for (int i = 0; i < WIDTH; i++)
		{
			for (int j = 0; j < HEIGHT; j++)
			{
				world[i][j] = Tileset.NOTHING;
			}
		}

		addHexagon(10, 10, 10, Tileset.FLOWER, world);

		renderer.renderFrame(world);
	}

	public static void addHexagon(int size, int leftUpperCornerX, int leftUpperCornerY, TETile tile, TETile[][] world)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = leftUpperCornerX - i; j < leftUpperCornerX + size + i; j++)
			{
				world[j][leftUpperCornerY + i] = tile;
				world[j][leftUpperCornerY + 2 * size - 1 - i] = tile;
			}
		}
	}
}
