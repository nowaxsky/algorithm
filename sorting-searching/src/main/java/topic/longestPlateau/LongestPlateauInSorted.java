package topic.longestPlateau;

import java.util.Arrays;

public class LongestPlateauInSorted {

  public static void main(String[] args) {
    int[] sequence = new int[20];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 5);
    }
    Arrays.sort(sequence);
    System.out.println("\n---Before sorting---\n");
    Arrays.stream(sequence).forEach(System.out::println);
    int length = longestPlateauInSorted(sequence);

    System.out.println("\n---The length of longest plateau---\n");
    System.out.println(length);
  }

  public static int longestPlateauInSorted(int[] arr) {
    int length = 1;
    for(int i=1; i<arr.length; i++) {
      if(arr[i] == arr[i-length]) {
        length++;
      } 
    }
    return length;
  }
}
