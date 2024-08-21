package byog.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.awt.*;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld
{
	private static final int HEIGHT = 40;
	private static final int WIDTH = 40;

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

		//		addHexagon(10, new Position(9, 0), Tileset.FLOWER, world);

		Position anchor = new Position(15, 0);

		addVerticalHexes(5, anchor, 3, world);
		addVerticalHexes(4, upperLeftHexPos(anchor, 3), 3, world);
		addVerticalHexes(4, upperRightHexPos(anchor, 3), 3, world);
		addVerticalHexes(3, upperLeftHexPos(upperLeftHexPos(anchor, 3), 3), 3, world);
		addVerticalHexes(3, upperRightHexPos(upperRightHexPos(anchor, 3), 3), 3, world);

		renderer.renderFrame(world);
	}

	private static void addHexagon(int size, Position leftLowerCorner, TETile tile, TETile[][] world)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = leftLowerCorner.X - i; j < leftLowerCorner.X + size + i; j++)
			{
				world[j][leftLowerCorner.Y + i] = tile;
				world[j][leftLowerCorner.Y + 2 * size - 1 - i] = tile;
			}
		}
	}

	private static Position upperHexPos(Position me, int size)
	{
		return new Position(me.X, me.Y + size * 2);
	}

	private static Position upperLeftHexPos(Position me, int size)
	{
		return new Position(me.X - size * 2 + 1, me.Y + size);
	}

	private static Position upperRightHexPos(Position me, int size)
	{
		return new Position(me.X + size * 2 - 1, me.Y + size);
	}

	private static TETile randomTile()
	{
		int key = new Random().nextInt();
		return switch (key % 5)
		{
			case 0 -> Tileset.FLOWER;
			case 1 -> Tileset.FLOOR;
			case 2 -> Tileset.MOUNTAIN;
			case 3 -> Tileset.SAND;
			default -> Tileset.WATER;
		};
	}

	private static void addVerticalHexes(int num, Position leftLowerMost, int size, TETile[][] world)
	{
		for (int i = 0; i < num; i++)
		{
			addHexagon(size, leftLowerMost, randomTile(), world);
			leftLowerMost = upperHexPos(leftLowerMost, size);
		}
	}

	private static class Position
	{
		public int X, Y;

		public Position(int x, int y)
		{
			X = x;
			Y = y;
		}
	}
}
