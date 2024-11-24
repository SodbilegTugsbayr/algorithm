import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fiboTest {
  private int[] parseArrayFromString(String line) {
    String[] parts = line.trim().split(",\\s*");
    int[] array = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {
        array[i] = Integer.parseInt(parts[i]);
    }
    return array;
  }

  @Test
  public void testFibo(){
    Fibonacci fibo = new Fibonacci();

    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab3/src/TestCase.txt"))) {
      String line = reader.readLine();
      String[] tokens = line.split(":");
      reader.close();

      int expected = Integer.parseInt(tokens[1]);
      int num = fibo.fibonacci(Integer.valueOf(tokens[0]));

      Assert.assertEquals(expected, num);
    } catch (IOException e) {
        e.printStackTrace();
        Assert.fail("Error");
    }
  }

  @Test
  public void testKnap(){
    Knapsack ks = new Knapsack();

    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab3/src/Knaptest.txt"))) {
      String line = reader.readLine();
      String[] tokens = line.split(":");
      reader.close();

      int w = Integer.parseInt(tokens[0]);
      int n = Integer.parseInt(tokens[1]);
      int[] weights = parseArrayFromString(tokens[3]);
      int[] values = parseArrayFromString(tokens[2]);
      int expected = Integer.parseInt(tokens[4]);
      int num = ks.knapsack(w, weights, values, n);

      Assert.assertEquals(expected, num);
  } catch (IOException e) {
      e.printStackTrace();
      Assert.fail("Error");
  }
  }
}