package leetcode;

/**
 * Created by 1990c on 11/15/2016.
 */
public abstract class AbstractClassTesting {
  static int a = 0;
  public void test(){};
  public abstract void abstractMethod();
  public void abc() {
    ABC.testing(0);
  }
}

class ABC {
  public static int testing (int a) {
    //can not be accessed if testing method is private
    return 0;
  }
}

