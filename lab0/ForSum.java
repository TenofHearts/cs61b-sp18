public class ForSum
{
    public static int for_sum(int[] arr)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int[] numbers = new int[]
        {9, 29, 15, 2, 22, 10, 6};
        System.out.println(for_sum(numbers));
    }
}
