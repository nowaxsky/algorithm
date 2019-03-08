package topic.shell;

import java.util.Arrays;

public class ShellSort {

  public static void main(String[] args) {
    int[] sequence = new int[10];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 1000);
    }
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    shellSort(sequence);

    System.out.println("\n---After sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);

  }

  public static void shellSort(int[] arr) {

    // 是長度也是間隔
    int num = arr.length / 2;

    // 間隔為1的時候就是一般的插入排序法
    while (num >= 1) {
      for (int i = num; i < arr.length; i++) {
        int pivot = arr[i];
        int j = i - num;

        // 若比左邊那組的對應數字還要小, 則將那組數字往右搬到右邊這組, 並繼續檢查更左邊的一組
        while (j >= 0 && arr[j] > pivot) {
          arr[j + num] = arr[j];
          j = j - num;
        }

        // 檢查完成後則插入
        arr[j + num] = pivot;
      }
      num = num / 2;
    }
  }
}
