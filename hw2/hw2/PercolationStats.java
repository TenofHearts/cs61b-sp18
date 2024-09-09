package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats
{
	private final double m;
	private final double s;
	private final int T;

	public PercolationStats(int N, int T, PercolationFactory pf)
	{
		if (N <= 0 || T <= 0)
		{
			throw new IllegalArgumentException("N and T must be positive.");
		}

		this.T = T;
		int SIZE = N * N;
		int[] t = new int[T];

		for (int i = 0; i < T; i++)
		{
			Percolation p = pf.make(N);
			int times = 0;

			while (!p.percolates())
			{
				int index = StdRandom.uniform(SIZE);
				while (p.isOpen(index / N, index % N))
				{
					index = StdRandom.uniform(SIZE);
				}
				p.open(index / N, index % N);
				times++;
			}
			t[i] = times;
		}

		m = StdStats.mean(t);
		s = StdStats.stddev(t);
	}

	public double mean()
	{
		return m;
	}

	public double stddev()
	{
		return s;
	}

	public double confidenceLow()
	{
		return m - 1.96 * s / Math.sqrt(T);
	}

	public double confidenceHigh()
	{
		return m + 1.96 * s / Math.sqrt(T);
	}
}
