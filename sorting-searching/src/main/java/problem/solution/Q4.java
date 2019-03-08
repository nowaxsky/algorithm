package problem.solution;

public class Q4 {

  public static void main(String[] args) {
    int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
    int target = 5;
    int ans = searchInRotatedArray(arr, target);
    System.out.println(ans);
  }

  public static int searchInRotatedArray(int[] arr, int target) {
    int n = arr.length;
    int ans = binarySearch(arr, target, 0, n - 1);
    return ans;
  }

  private static int binarySearch(int[] arr, int target, int start, int end) {

    int middle = (end + start) / 2;

    if (target == arr[middle])
      return middle;

    // 數列分兩段後, 如果兩段都是有序則做二元搜索
    if (arr[middle] >= arr[start] && arr[middle + 1] <= arr[end]) {
      if (target >= arr[start] && target <= arr[middle]) {
        return binarySearch(arr, target, start, middle);
      } else {
        return binarySearch(arr, target, middle + 1, end);
      }
    }

    // 若某一段不是正常排序, 則可以透過該段最左側的數值是否比target大來判斷, 若是比target大則答案在另外一段, 反之亦然
    else if (arr[middle] <= arr[start]) {
      if (target >= arr[start]) {
        return binarySearch(arr, target, start, middle);
      } else {
        return binarySearch(arr, target, middle + 1, end);
      }
    } else if (arr[middle + 1] >= arr[end]) {
      if (target >= arr[middle + 1]) {
        return binarySearch(arr, target, middle + 1, end);
      } else {
        return binarySearch(arr, target, start, middle);
      }
    } else {
      return -1;
    }

  };


}
