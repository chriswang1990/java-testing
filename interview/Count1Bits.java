package testing.interview;

/**
 * Created by 1990c on 2/17/2017.
 */
public class Count1Bits {
    public static int count1Bits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count1Bits(1));
    }
}
