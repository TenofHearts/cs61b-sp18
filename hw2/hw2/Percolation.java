package hw2;

import com.sun.source.doctree.EscapeTree;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.awt.image.renderable.RenderableImage;

public class Percolation
{
	private final int LEN;
	private int num;
	private WeightedQuickUnionUF ds;
	private boolean[][] graph;

	public Percolation(int n)
	{
		if (n <= 0)
		{
			throw new IllegalArgumentException("N must be positive.");
		}
		LEN = n;
		num = 0;

		ds = new WeightedQuickUnionUF(n * n);

		graph = new boolean[n][n];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				graph[i][j] = false;
			}
		}
	}

	private void connectUp(int i)
	{
		int target = i - LEN;
		if (i < LEN)
		{
			return;
		}
		else if (graph[target / LEN][target % LEN])
		{
			ds.union(i, target);
		}
	}

	private void connectDown(int i)
	{
		int target = i + LEN;
		if (i >= LEN * (LEN - 1))
		{
			return;
		}
		else if (graph[target / LEN][target % LEN])
		{
			ds.union(i, target);
		}
	}

	private void connectLeft(int i)
	{
		int target = i - 1;
		if (i % LEN == 0)
		{
			return;
		}
		else if (graph[target / LEN][target % LEN])
		{
			ds.union(i, target);
		}
	}

	private void connectRight(int i)
	{
		int target = i + 1;
		if ((i + 1) % LEN == 0)
		{
			return;
		}
		else if (graph[target / LEN][target % LEN])
		{
			ds.union(i, target);
		}
	}

	private void connectAll(int row, int col)
	{
		int index = row * LEN + col;

		connectDown(index);
		connectLeft(index);
		connectUp(index);
		connectRight(index);
	}

	private boolean checksBounds(int row, int col)
	{
		return !(row >= 0 && row < LEN && col >= 0 && col < LEN);
	}

	public void open(int row, int col)
	{
		if (checksBounds(row, col))
		{
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		else if (!graph[row][col])
		{
			graph[row][col] = true;
			connectAll(row, col);
			num++;
		}
	}

	public boolean isOpen(int row, int col)
	{
		if (checksBounds(row, col))
		{
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		return graph[row][col];
	}

	public boolean isFull(int row, int col)
	{
		return !isOpen(row, col);
	}

	public int numberOfOpenSites()
	{
		return num;
	}

	public boolean percolates()
	{
		return false;
	}
}
