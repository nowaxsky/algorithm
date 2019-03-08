package topic.merge;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] sequence = new int[10];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 1000);
    }
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    mergeSort(sequence);

    System.out.println("\n---After sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);

  }

  public static void mergeSort(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    mergeSortRecursive(arr, result, 0, n - 1);
  }

  public static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {

    // 當end < start則繼續進行divide, 若start == end則代表已經無法再分割, 只剩下一個數字也無須排序
    if (start < end) {
      int middle = (start + end) / 2;

      // 先把數列分為左邊排序和右邊排序
      mergeSortRecursive(arr, result, start, middle);
      mergeSortRecursive(arr, result, middle + 1, end);

      // 最後再把結果合併
      merge(arr, result, start, middle, end);
    }
  }

  /**
   * 傳入的arr是start ~ middle已經排序完成, middle+1 ~ end已經排序完成, 例如:[10,19,31,2,9,21].
   * 
   * merge的主要功能是把2條已經排序好的數列進行合併(其實只有一條arr, 可以想像成arr前半段紀錄第一條有序數列, arr後半段也記錄一條有序數列).
   * 
   * 在本例中傳入的參數中, result是沒有作用的, 需要從外界傳入的唯一理由是可以直接取得陣列長度, 但其實也可以在merge以new int[arr.length]來建立.
   * 
   * 保留這樣做法的主要原因為, 在多數的分治法中, arr可能有變化, 所以需要從最外層傳入暫存的result(因為內層在經過多層divide後已經不知道最原始的arr長度,
   * 只是本例恰好arr長度沒有改變)
   * 
   * @param arr
   * @param result
   * @param start
   * @param middle
   * @param end
   */
  private static void merge(int[] arr, int[] result, int start, int middle, int end) {

    // 先抄寫原數列到result暫存
    for (int i = start; i <= end; i++) {
      result[i] = arr[i];
    }

    int index1 = start;
    int index2 = middle + 1;
    int current = start;

    // 當兩條數列還未有任何一條遍歷完則會進入迴圈, 當有任何一條數列遍歷完成則跳出
    while (index1 <= middle && index2 <= end)

      // 取出兩條中比較小的數字放入暫存
      result[current++] = arr[index1] < arr[index2] ? arr[index1++] : arr[index2++];

    // 程式到此代表已經只剩下一條數列還有一些數字未遍歷, 則因為有序, 所以直接全部接上去就好
    while (index1 <= middle) {
      result[current++] = arr[index1++];
    }

    // 與上同理
    while (index2 <= middle) {
      result[current++] = arr[index2++];
    }

    // 最後把排序好的result寫入原數列
    for (int i = start; i <= end; i++) {
      arr[i] = result[i];
    }
  }
}
