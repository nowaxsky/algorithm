package topic.longestPlateau;

import java.util.Arrays;

public class LongestPlateau {

  public static void main(String[] args) {
    int[] sequence = new int[] {2,2,2,6,6,1,3,3,3,3,-1,-1};
    
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    int length = longestPlateau(sequence);

    System.out.println("\n---The length of longest plateau---\n");
    System.out.println(length);
  }

  public static int longestPlateau(int[] arr) {
    int count = 1;
    int max = 1;
    for(int i=1; i<arr.length; i++) {
      if(arr[i] == arr[i-1]) {
        count++;
        max = Math.max(count, max);
      } else {
        count = 1;
      }
    }
    return max;
  }
}
