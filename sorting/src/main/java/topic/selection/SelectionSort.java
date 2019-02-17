package topic.selection;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] sequence = new int[10];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 1000);
    }
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    selectionSort(sequence);

    System.out.println("\n---After sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);

  }

  public static void selectionSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i+1; j < n; j++) {
        if (arr[j] < arr[min])
          min = j;
      }
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }

  }
}
