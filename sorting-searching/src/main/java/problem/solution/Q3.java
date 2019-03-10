package problem.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {

  public static void main(String[] args) {
    String[] arr = {"cat", "dog", "tac", "god", "act"};
    groupAnagrams(arr);
    for (String s : arr) {
      System.out.println(s);
    }
  };

  public static void groupAnagrams(String[] arr) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : arr) {

      // 取排序好的字串當作key, 如此可以還原字謎
      String key = sortString(s);
      if (map.get(key) != null)
        map.get(key).add(s);
      else {
        List<String> values = new ArrayList<>();
        values.add(s);
        map.put(key, values);
      }
    }

    int i = 0;
    for (String key : map.keySet()) {
      List<String> values = map.get(key);
      for (String value : values) {
        arr[i] = value;
        i++;
      }
    }

  }

  /**
   * 將字串排序
   * 
   * @param s
   * @return
   */
  private static String sortString(String s) {
    char[] charArray = s.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }

}
