package topic.bubble;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] sequence = new int[10];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 1000);
    }
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    bubbleSort(sequence);

    System.out.println("\n---After sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);

  }

  public static void bubbleSort(int[] arr) {
    int n = arr.length;
    
    // 最後一個不用換故-1
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {

        // 若 arr[j]> arr[j + 1]則交換
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }

      }
    }
  }
}
