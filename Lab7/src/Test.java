import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Assert;

public class Test {
  private int[] parseArrayFromString(String line) {
    String[] parts = line.trim().split(",\\s*");
    int[] array = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {
        array[i] = Integer.parseInt(parts[i]);
    }
    return array;
  }

  @org.junit.Test
  public void testKnapsack() {
    App app = new App();
    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab7/src/testcase.txt"))) {
      String line = reader.readLine();
      String[] tokens = line.split(":");
      reader.close();

      int expected = Integer.parseInt(tokens[4]);
      int n = Integer.parseInt(tokens[2]);
      int back = Integer.parseInt(tokens[3]);
      int[] w = parseArrayFromString(tokens[0]);
      int[] p = parseArrayFromString(tokens[1]);

      int max = app.fractionalKnapsack(w, p, n, back);

      Assert.assertEquals(expected, max);
    } catch (IOException e) {
        e.printStackTrace();
        Assert.fail("Error");
    }
  }
}
