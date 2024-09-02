package hw2;

import com.sun.source.doctree.EscapeTree;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.awt.image.renderable.RenderableImage;

public class Percolation
{
	private final int LEN;
	private WeightedQuickUnionUF ds;
	private boolean[][] graph;

	public Percolation(int n)
	{
		LEN = n;

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
		if (i < LEN)
		{
			return;
		}
		else
		{
			ds.union(i, i - LEN);
		}
	}

	private void connectDown(int i)
	{
		if (i >= LEN * (LEN - 1))
		{
			return;
		}
		else
		{
			ds.union(i, i + LEN);
		}
	}

	private void connectLeft(int i)
	{
		if (i % LEN == 0)
		{
			return;
		}
		else
		{
			ds.union(i, i - 1);
		}
	}

	private void connectRight(int i)
	{
		if ((i + 1) % LEN == 0)
		{
			return;
		}
		else
		{
			ds.union(i, i + 1);
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

	public void open(int row, int col)
	{
		graph[row][col] = true;
		connectAll(row, col);
	}

	public boolean isOpen(int row, int col)
	{
		return graph[row][col];
	}

	public boolean isFull(int row, int col)
	{
		return !isOpen(row, col);
	}

	public int numberOfOpenSites()
	{
		return 0;
	}

	public boolean percolates()
	{
		return false;
	}
}
