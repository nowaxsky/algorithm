package topic.quick;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] sequence = new int[10];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 1000);
    }

    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    quickSort(sequence);
    // System.out.println("pivot: " + partition(sequence, 0, sequence.length - 1));

    System.out.println("\n---After sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);

  }

  public static void quickSort(int[] arr) {
    int n = arr.length;
    quickSortRecursive(arr, 0, n - 1);
  }

  public static void quickSortRecursive(int arr[], int start, int end) {
    if (start < end) {

      // arr已經經過處理, 使數列位置小於pivot-1的數都小於等於arr[pivot], 位置大於等於pivot的數都大於等於arr[pivot]
      int pivot = partition(arr, start, end);
//      System.out.println(pivot);
      quickSortRecursive(arr, start, pivot - 1);
      quickSortRecursive(arr, pivot, end);
    }
  }

  public static int partition(int arr[], int start, int end) {
    int pivot = arr[(start + end) / 2];
    // System.out.println("middle: " + pivot);
    while (start <= end) {

      // 若該數字比pivot小則排序正確, 繼續檢查下一個數字, 直到停下來代表該數比pivot大需要移到右邊
      while (arr[start] < pivot)
        start++;

      // 若該數字比pivot大則排序正確, 繼續檢查下一個數字, 直到停下來代表該數比pivot小需要移到左邊
      while (arr[end] > pivot)
        end--;

      if (start <= end) {
        // 左右錯誤排序的數字交換
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // 繼續檢查下一個數字
        start++;
        end--;

      }
    }
    // arr已經經過處理, 使數列位置小於start-1的數都小於等於arr[start], 位置大於等於start的數都比arr[start]大
    return start;
  }

}
