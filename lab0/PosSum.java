public class PosSum
{
    public static void pos_sum(int[] arr, int n)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int sum = arr[i];
            if (arr[i] > 0)
            {
                for (int j = i + 1; j <= i + n; j++)
                {
                    if (j >= arr.length)
                    {
                        break;
                    }
                    sum += arr[j];
                }
            }
            arr[i] = sum;
        }
    }

    public static void main(String[] args)
    {
        int[] a =
        {1, 2, -3, 4, 5, 4};
        int n = 3;
        pos_sum(a, n);
        System.out.println(java.util.Arrays.toString(a));
    }
}
