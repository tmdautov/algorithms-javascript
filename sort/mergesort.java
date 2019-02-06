/**
Merge sort is a divide-and-conquer algorithm based on the idea of breaking down a list into several sub-lists
until each sublist consists of a single element and merging those sublists in a manner that results into a sorted list.

*/

public class MergeSort {

    public static void main(String[] args) {
        int[] a = { 5, 1, 6, 2, 3, 4 };
        mergeSort(a, a.length);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid]; // why n - mid?

        for (int i = 0; i < mid; i++) l[i] = a[i];
        for (int i = mid; i < n; i++) r[i - mid] = a[i]; // why i - mid?

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;


        // Select the smallest value from the front of each list (excluding values already in the sorted array)
        while (i < left && j < right) {
            if (l[i] <= r[j]) // Select the minimum of the two values
                a[k++] = l[i++]; // Add the selected value to the sorted array
            else
                a[k++] = r[j++];
        }


        // When one list becomes empty, copy all values from the remaining array into the sorted array
        while (i < left) a[k++] = l[i++];
        while (j < right) a[k++] = r[j++];
    }
}
