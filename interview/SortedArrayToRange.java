package testing.interview;

/**
 * Created by 1990c on 9/19/2016.
 */
public class SortedArrayToRange {

  public static String arrayToRange(int[] input) {
    String ans = "";
    if (input == null || input.length == 0) {
      return ans;
    }
    int len = input.length;
    int i = 0;
    while (i < len) {
      for (int j = i + 1; j < len; j++) {
        if (input[j] == input[j - 1] + 1) {
          if (j == len - 1) {
            return ans += input[i] + "-" + input[j];
          } else {
            continue;
          }
        } else {
          if (j == i + 1) {
            if (j == len - 1) {
              return ans + input[i] + ", " + input[j];
            } else {
              ans += input[i] + ", ";
              i++;
            }
          } else {
            if (j == len - 1) {
              return ans + input[i] + "-" + input[j - 1] + ", " + input[j];
            } else {
              ans += input[i] + "-" + input[j - 1] + ", ";
              i = j;
            }
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String ans = arrayToRange(new int[]{1,1,2,2,3,5,7,8,13,20});
    System.out.println(ans);
  }
}
