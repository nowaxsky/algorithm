package topic.insertion;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] sequence = new int[10];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 1000);
    }
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    insertionSort(sequence);

    System.out.println("\n---After sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);

  }

  public static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {

      // 取出欲插入的數字
      int pivot = arr[i];
      int j = 0;

      // 從欲插入數字左邊的數字開始檢查
      for (j = i - 1; j >= 0; j--) {

        // 若左邊的數字大於欲插入的數字則把左邊的數字往右移一格
        if (pivot < arr[j])
          arr[j + 1] = arr[j];

        else
          break;
      }

      // 左邊的數字比欲插入的數字小, 則在該數字右邊放入欲插入的數字
      arr[j + 1] = pivot;

    }
  }
}
