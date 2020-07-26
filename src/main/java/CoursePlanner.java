import java.util.*;

public class CoursePlanner {
  // this method prints out: whether it is possible to take all the given courses and
  // one possible schedule for the given courses
  public static void plan(int numberOfCourses, int[][] prerequisites) {
    return;
  }

  // this is a helper method for plan; it returns a boolean to indicate if a given series of courses can be possibly scheduled
  public static boolean check(int numberOfCourses, int[][] prerequisites) {
    // remove these two lines
    if (RightSolution.check(numberOfCourses, prerequisites)) return false;
    else return true;
  }
}
