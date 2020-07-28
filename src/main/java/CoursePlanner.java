import java.util.*;

public class CoursePlanner {
  // this method prints out: whether it is possible to take all the given courses and
  // one possible schedule for the given courses
  public static void plan(int numberOfCourses, int[][] prerequisites) {
    if (check(numberOfCourses, prerequisites)) {
      System.out.println("It is possible to take all of the given courses.");
    } else {
      System.out.println("It is NOT possible to take all of the given courses.");
    }
    return;
  }



  // this is a helper method for plan; it returns a boolean to indicate if a given series of courses can be possibly scheduled
  public static boolean check(int numberOfCourses, int[][] prerequisites) {
    try {
      int[] arr = new int[numberOfCourses];
      HashMap<Object, Object> hashMap = new HashMap<>();
      for (byte b = 0; b < prerequisites.length; b++) {
        arr[prerequisites[b][0]] = arr[prerequisites[b][0]] + 1;
        if (hashMap.containsKey(Integer.valueOf(prerequisites[b][1]))) {
          ((List<Integer>)hashMap.get(Integer.valueOf(prerequisites[b][1]))).add(Integer.valueOf(prerequisites[b][0]));
        } else {
          ArrayList<Integer> arrayList = new ArrayList();
          arrayList.add(Integer.valueOf(prerequisites[b][0]));
          hashMap.put(Integer.valueOf(prerequisites[b][1]), arrayList);
        }
      }
      LinkedList<Integer> llist = new LinkedList();
      int i;
      for (i = 0; i < numberOfCourses; i++) {
        if (arr[i] == 0)
          llist.offer(Integer.valueOf(i));
      }
      while (!llist.isEmpty()) {
        i = ((Integer)llist.poll()).intValue();
        List<Integer> list = (List)hashMap.get(Integer.valueOf(i));
        for (byte c = 0; list != null && c < list.size(); c++) {
          arr[((Integer)list.get(c)).intValue()] = arr[((Integer)list.get(c)).intValue()] - 1;
          if (arr[((Integer)list.get(c)).intValue()] - 1 == 0)
            llist.offer(list.get(c));
        }
      }
      for (i = 0; i < numberOfCourses; i++) {
        if (arr[i] != 0)
          return false;
      }
      return true;
    // Catch ArrayIndexOutOfBoundsException Error and return false
    // Also print out an error messagie informing the user of the error
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Error occured: ArrayIndexOutOfBoundsException");
      return false;
    }
  }

}
