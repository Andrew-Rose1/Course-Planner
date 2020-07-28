import java.util.*;

public class PlanTest {
  public static void main(String[] args) {
    //Testing Cases
    CoursePlanner obj = new CoursePlanner();
    obj.plan(4, prerequisiteGenerator(5));
    obj.plan(12, prerequisiteGenerator(5));
    obj.plan(5, prerequisiteGenerator(5));
  }

  // this method generates a list of prerequisits as a 2D array
  private static int[][] prerequisiteGenerator(int size) {
    // remove these two lines
    int[][] result = new int[size][2];
    for (int i = 0; i < size; i++) {
      while (result[i][0] == result[i][1]) {
        result[i][0] = (int)(Math.random()*10);
        result[i][1] = (int)(Math.random()*10);
        // Iterate through all pairs in current 2D array and check if new pair is equal to any of them
        // If a duplicate is found, continue to change it's values until it is no longer a duplicate
        if (i > 0) {
          for (int l = 0; l < i; l++) {
            while ((result[l][0] == result[i][0]) && (result[l][1] == result[i][1])) {
              // Test print to see the duplicated value
              //System.out.println("Found a duplicate " + result[l][0] + "," + result[l][1] + " is the same as " + result[i][0] + "," + result[i][1]);
              result[i][0] = (int)(Math.random()*10);
              result[i][1] = (int)(Math.random()*10);
            }
          }
        }
      }
    }

    //TESTING --- Print out the 2D array
    for (int m = 0; m < size; m++) {
      System.out.print("(");
      for (int n = 0; n < 2; n++) {
        System.out.print(result[m][n] + " ");
      }
      System.out.print(")");
      System.out.println(" ");
    }


    return result;
  }
}
