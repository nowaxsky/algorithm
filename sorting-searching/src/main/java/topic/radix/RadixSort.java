package topic.radix;

import java.util.Arrays;

public class RadixSort {

  public static void main(String[] args) {
    int[] sequence = new int[10];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 1000);
    }
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    radixSort(sequence);

    System.out.println("\n---After sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);

  }

  public static void radixSort(int[] arr) {

    // 先找出最大值
    int max = arr[0];
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      if (arr[i] > max)
        max = arr[i];
    }

    // 從最小位數開始, exp代表位數
    for (int exp = 1; max / exp > 0; exp *= 10) {
      int output[] = new int[n]; // output array
      int i;

      int count[] = new int[10];
      Arrays.fill(count, 0);

      // 計算每個桶子內有多少個數字
      for (i = 0; i < n; i++)
        count[(arr[i] / exp) % 10]++;

      // 將數列改為累加數列
      for (i = 1; i < 10; i++) {
        count[i] += count[i - 1];
      }

      // (arr[i] / exp) % 10 是exp位數的數字
      for (i = n - 1; i >= 0; i--) {

        /*
         * 累加數列代表的其實是下一個數放進去的位置, 假設[1,1,5,5,6,7,7,9,10,10]代表第N位數是2的數字有4個(5-1), 且如果這4個其中的第1個數字進來,
         * 會被安排在output[5-1]的位置, 並把count[2]--, 變成[1,1,4,5,6,7,7,9,10,10] 接下來第二個進來的會被安排在[4-1]的位置,
         * 直到完成.
         */
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
      }

      // 將暫存複製出來
      for (i = 0; i < n; i++)
        arr[i] = output[i];
    }
  }
}
