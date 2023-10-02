package vn.edu.tdtu;

import java.util.Arrays;

public class ArrayHandler {
    public static void sort(int arr[])
    {
        Arrays.sort(arr);
    }

    public static int[] merge(int a[], int b[])
    {
        int c[] = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++)
        {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++)
        {
            c[a.length + i] = b[i];
        }
        return c;
    }
}                