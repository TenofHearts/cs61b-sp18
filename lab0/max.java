public class max
{
    public static int larger(int a, int b)
    {
        if (a >= b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }

    public static int maxi(int[] arr)
    {
        int i = 1;
        int maximun = arr[0];
        while (i < arr.length)
        {
            maximun = larger(maximun, arr[i]);
            i++;
        }
        return maximun;
    }

    public static void main(String[] args)
    {
        int[] numbers = new int[]
        {9, 2, 15, 2, 22, 10, 6};
        System.out.println(maxi(numbers));
    }
}
