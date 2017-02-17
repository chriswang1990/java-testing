package testing.interview;

/**
 * Created by 1990c on 2/17/2017.
 */
public class fibonacci {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long cur = 1;
        long prev = 0;
        for (int i = 2; i <= n; i++) {
            long temp = cur;
            cur = cur + prev;
            prev = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(8181));
    }
}
