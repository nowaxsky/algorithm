package problem.solution;

public class Q2 {

  public static void main(String[] args) {
    int[] a = {10, 12, 13, 30, 38, 0, 0, 0, 0, 0, 0};
    int[] b = {16, 17, 19, 20, 22, 49};
    sortedMerge(a, b, 5, 6);
    for (int i : a) {
      System.out.println(i);
    }

  };

  public static void sortedMerge(int[] a, int[] b, int numA, int numB) {

    int indexA = numA - 1;
    int indexB = numB - 1;
    int i = numA + numB - 1;

    while (i >= 0) {
      
      if(indexA < 0) {
        a[i--] = b[indexB--];
        continue;
      }
      if(indexB < 0) {
        a[i--] = a[indexA--];
        continue;
      }
      
      if (a[indexA] > b[indexB]) {
        a[i--] = a[indexA--];
      } else {
        a[i--] = b[indexB--];
      }
      
    }
  }

}
