public class drawing_triangles
{
    public static void DrawTriangle(int n)
    {
        int i = 0;
        String output = "";
        while (i < n)
        {
            i++;
            output += "*";
            System.out.println(output);
        }
    }

    public static void main(String[] args)
    {
        DrawTriangle(5);
        DrawTriangle(10);
    }
}
